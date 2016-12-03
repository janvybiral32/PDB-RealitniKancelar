/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vutbr.fit.pdb.realitnikancelar;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.InvalidObjectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

/**
 * @author Honza
 *         Tady budou ulozeny veskere informace o objektech.
 */
public class Data {
    public static class JGeometry2ShapeException extends Exception {
    }

    ;
    //rozmery mapy
    public static int width = 1000;
    public static int height = 1000;

    //pro kazdy typ geometrickeho objektu jsou dve pole
    //jedno s geometrickymi objekty a jedno s informacemi o tech objektech
    
    public static ArrayList<Owner> owners = new ArrayList<>();

    public static ArrayList<Point> points = new ArrayList<>();
    public static ArrayList<ObjectInfo> pointsInfo = new ArrayList<>();

    //lomena cara je reprezentovana jako pole bodu
    public static ArrayList<ArrayList<Point>> polylines = new ArrayList<>();
    public static ArrayList<ObjectInfo> polylinesInfo = new ArrayList<>();

    public static ArrayList<Ellipse2D> ellipses = new ArrayList<>();
    public static ArrayList<ObjectInfo> ellipsesInfo = new ArrayList<>();

    public static ArrayList<Rectangle> rectangles = new ArrayList<>();
    public static ArrayList<ObjectInfo> rectanglesInfo = new ArrayList<>();

    public static ArrayList<Polygon> polygons = new ArrayList<>();
    public static ArrayList<ObjectInfo> polygonsInfo = new ArrayList<>();

    //tady se budou potom nacitat data z databaze, zatim tady vytvarim nejake objekty rucne
    public static void loadData() {
        
        //vymazat vsechna stara data z aplikace
        removeAllFromApp();
        
        //zjisti se rozmery mapy
        width = 1000;
        height = 1000;
        
        //pridam nejake ownery kvuli testovani
        owners.add(new Owner(true));
        owners.add(new Owner("Honza", "Brno", true));
        
       

        try (Statement stmt = ConnectDialog.conn.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT * FROM OBJEKTY");
            while (res.next()) {
                loadShape(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //nejake objekty na testovani, protoze v databazi nic neni
        /*
        rectangles.add(new Rectangle(100, 100, 300, 200));
        rectanglesInfo.add(new ObjectInfo());
        rectanglesInfo.get(0).nazev = "Ahoj";

        rectangles.add(new Rectangle(500, 500, 300, 200));
        rectanglesInfo.add(new ObjectInfo());
        rectanglesInfo.get(1).nazev = "XXX";
        

        
        //vymazou se predchozi data
        points.clear();
        pointsInfo.clear();
        
        polylines.clear();
        polylinesInfo.clear();
        
        ellipses.clear();
        ellipsesInfo.clear();
        
        rectangles.clear();
        rectanglesInfo.clear();
        
        polygons.clear();
        polygonsInfo.clear();
        
        //pridame nejake objekty
        points.add(new Point(100, 400));
        pointsInfo.add(new ObjectInfo());
        
        ArrayList<Point> polyline = new ArrayList<Point>();
        polyline.add(new Point(500, 100));
        polyline.add(new Point(600, 200));
        polyline.add(new Point(550, 300));
        polylines.add(polyline);
        polylinesInfo.add(new ObjectInfo());
        
        ellipses.add(new Ellipse2D.Double(500, 400, 50, 100));
        ellipsesInfo.add(new ObjectInfo());
        
        rectangles.add(new Rectangle(100, 100, 300, 200));
        rectanglesInfo.add(new ObjectInfo());
        
        Polygon polygon = new Polygon();
        polygon.addPoint(700, 100);
        polygon.addPoint(800, 50);
        polygon.addPoint(900, 200);
        polygon.addPoint(850, 300);
        polygons.add(polygon);
        polygonsInfo.add(new ObjectInfo());
        */
    }

    private static void loadShape(ResultSet res) throws Exception, SQLException {
        byte[] image = new byte[0];
        JGeometry tempGeo;
        Shape shape;

        image = res.getBytes("geometrie");
        ObjectInfo info = ObjectInfo.createFromDB(res);

        //process shape
        tempGeo = JGeometry.load(image);
        shape = ShapeHelper.jGeometry2Shape(tempGeo);
        populatePanel(shape, info);
    }

    private static void populatePanel(Shape shape, ObjectInfo info) {
        if (shape instanceof Rectangle2D) {
            Rectangle rectangle = shape.getBounds();
            rectangles.add(rectangle);
            rectanglesInfo.add(info);
            return;
        } else if (shape instanceof Ellipse2D) {
            ellipses.add((Ellipse2D) shape);
            ellipsesInfo.add(info);
            return;
        } else if (shape instanceof GeneralPath) {
            Polygon shapePoly = new Polygon();
            PathIterator iterator = shape.getPathIterator(null);
            float[] floats = new float[6];
            while (!iterator.isDone()) {
                int type = iterator.currentSegment(floats);
                int x = (int) floats[0];
                int y = (int) floats[1];
                if(type != PathIterator.SEG_CLOSE) {
                    shapePoly.addPoint(x, y);
                }
                iterator.next();
            }
            polygons.add((Polygon) shapePoly);
            polygonsInfo.add(info);
            return;
        }

}

    // ukladani dat do DB
    public static void saveData() throws InvalidObjectException, SQLException {
        //Vytvorime testovaci sektor, bacha, smaze vsechny ostatni
        Sektor.testovaciSektor();
        Shape current;
        ObjectInfo currentInfo;
        Connection conn = ConnectDialog.conn;

        for (int i = 0; i < owners.size(); i++)
        {
            if (!owners.get(i).modifiedOwner && 
                    !owners.get(i).newOwner &&
                    !owners.get(i).deletedOwner)
            {
                continue; //neni novy ani modifikovany ani smazany, preskocit
            }
            
            if (owners.get(i).deletedOwner)
            {
                //byl smazany v aplikaci, je treba ho smazat z DB
                continue;
            }
            
            //je novy nebo modifikovany, updatovat nebo pridat v DB
        }

        Map<ObjectInfo, Shape> objects = mergeShapes();

        //vycistit objekty
        PreparedStatement del = conn.prepareStatement("DELETE FROM objekty");
        del.execute();

        for (Map.Entry<ObjectInfo, Shape> entry : objects.entrySet())
        {
            currentInfo = entry.getKey();
            
            if (!currentInfo.modifiedInfo && 
                    !currentInfo.modifiedGeometry && 
                    !currentInfo.modifiedImage &&
                    !currentInfo.newObject &&
                    !currentInfo.deletedObject)
            {
                continue; //neni novy ani modifikovany ani smazany, preskocit
            }
            
            if (currentInfo.deletedObject)
            {
                //byl smazany v aplikaci, je treba ho smazat z DB
                continue;
            }
            
            //je novy nebo modifikovany, updatovat nebo pridat v DB
            
            current = entry.getValue();

            JGeometry jGeo = ShapeHelper.shape2jGeometry(current);
            //Nejspis se to musi vsechno vyjmenovat pokud chceme doplnovat pozdeji
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO objekty (id," +
                    " nazev,typ,editable,popis,majitel,sektor,geometrie,majitelOd," +
                    "majitelDo, existenceOd,existenceDo,rekonstrukceOd,rekonstrukceDo) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)" +
                    "")) {
                STRUCT obj = JGeometry.store(conn, jGeo);
                stmt.setInt(1, currentInfo.id);
                stmt.setString(2, currentInfo.nazev);
                stmt.setString(3, currentInfo.typ);
                stmt.setBoolean(4, currentInfo.editable);
                stmt.setString(5, currentInfo.popis);
                /* BACHA, ZATIM JENOM JEDEN MAJITEL*/
                stmt.setInt(6, currentInfo.majitele.get(0).id);
                stmt.setInt(7, currentInfo.sektor);
                stmt.setObject(8, obj);
                /* BACHA, ZATIM JENOM JEDEN MAJITEL*/
                stmt.setDate(9, new java.sql.Date(currentInfo.majitelOd.get(0).getTime()));
                stmt.setDate(10, new java.sql.Date(currentInfo.majitelDo.get(0).getTime()));
                stmt.setDate(11, new java.sql.Date( currentInfo.existenceOd.getTime()));
                stmt.setDate(12, new java.sql.Date( currentInfo.existenceDo.getTime()));
                stmt.setDate(13, new java.sql.Date( currentInfo.rekonstrukceOd.getTime()));
                stmt.setDate(14, new java.sql.Date( currentInfo.rekonstrukceDo.getTime()));

                stmt.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        dataSaved();
    }

    public static Map mergeShapes() {
        Map<ObjectInfo, Shape> objects = new HashMap<>();
        for (int i = 0; i < rectangles.size(); i++)
            objects.put(rectanglesInfo.get(i), rectangles.get(i));
        for (int i = 0; i < ellipses.size(); i++)
            objects.put(ellipsesInfo.get(i), ellipses.get(i));
        for (int i = 0; i < polygons.size(); i++)
            objects.put(polygonsInfo.get(i), polygons.get(i));
        return objects;
    }
    
    //vola se po ulozeni dat do DB
    //pro vsechny objekty se nastavi, ze nejsou nove ani modifikovane
    //smazane se smazou z aplikace
    public static void dataSaved()
    {
        removeDeletedFromApp();
        
        for (int i = 0; i < owners.size(); i++)
        {
            owners.get(i).newOwner = false;
            owners.get(i).modifiedOwner = false;
        }
        for (int i = 0; i < points.size(); i++)
        {
            pointsInfo.get(i).newObject = false;
            pointsInfo.get(i).modifiedGeometry = false;
            pointsInfo.get(i).modifiedInfo =  false;
            pointsInfo.get(i).modifiedImage = false;
        }
        for (int i = 0; i < polylines.size(); i++)
        {
            polylinesInfo.get(i).newObject = false;
            polylinesInfo.get(i).modifiedGeometry = false;
            polylinesInfo.get(i).modifiedInfo =  false;
            polylinesInfo.get(i).modifiedImage = false;
        }
        for (int i = 0; i < rectangles.size(); i++)
        {
            rectanglesInfo.get(i).newObject = false;
            rectanglesInfo.get(i).modifiedGeometry = false;
            rectanglesInfo.get(i).modifiedInfo =  false;
            rectanglesInfo.get(i).modifiedImage = false;
        }
        for (int i = 0; i < ellipses.size(); i++)
        {
            ellipsesInfo.get(i).newObject = false;
            ellipsesInfo.get(i).modifiedGeometry = false;
            ellipsesInfo.get(i).modifiedInfo =  false;
            ellipsesInfo.get(i).modifiedImage = false;
        }
        for (int i = 0; i < polygons.size(); i++)
        {
            polygonsInfo.get(i).newObject = false;
            polygonsInfo.get(i).modifiedGeometry = false;
            polygonsInfo.get(i).modifiedInfo =  false;
            polygonsInfo.get(i).modifiedImage = false;
        }
    }
    
    //smaze vsechna data z aplikace
    public static void removeAllFromApp()
    {
        owners.clear();
        
        points.clear();
        pointsInfo.clear();
        
        polylines.clear();
        polylinesInfo.clear();
        
        rectangles.clear();
        rectanglesInfo.clear();
        
        ellipses.clear();
        ellipsesInfo.clear();
        
        polygons.clear();
        polygonsInfo.clear();
    }
    
    //vymaze objekty s priznakem deleted z aplikace
    public static void removeDeletedFromApp()
    {
        for (int i = 0; i < owners.size(); i++)
        {
            if (owners.get(i).deletedOwner)
            {        
                owners.remove(i);
                i--;
            }
        }
        for (int i = 0; i < points.size(); i++)
        {
            if (pointsInfo.get(i).deletedObject)
            {        
                points.remove(i);
                pointsInfo.remove(i);
                i--;
            }
        }
        for (int i = 0; i < polylines.size(); i++)
        {
            if (polylinesInfo.get(i).deletedObject)
            {        
                polylines.remove(i);
                polylinesInfo.remove(i);
                i--;
            }
        }
        for (int i = 0; i < rectangles.size(); i++)
        {
            if (rectanglesInfo.get(i).deletedObject)
            {        
                rectangles.remove(i);
                rectanglesInfo.remove(i);
                i--;
            }
        }
        for (int i = 0; i < ellipses.size(); i++)
        {
            if (ellipsesInfo.get(i).deletedObject)
            {        
                ellipses.remove(i);
                ellipsesInfo.remove(i);
                i--;
            }
        }
        for (int i = 0; i < polygons.size(); i++)
        {
            if (polygonsInfo.get(i).deletedObject)
            {        
                polygons.remove(i);
                polygonsInfo.remove(i);
                i--;
            }
        }
    }
}
