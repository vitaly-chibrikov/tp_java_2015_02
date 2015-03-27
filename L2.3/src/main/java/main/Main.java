package main;

import io.ObjectWriter;
import reflection.ReflectionHelper;
import sax.ReadXMLFileSAX;
import time.TimeHelper;
import time.TimeService;
import vfs.VFS;
import vfs.VFSImpl;

import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TimerTask;

@SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "UnusedDeclaration"})
public class Main {

    public static void main(String[] args) {
        //randomExample();
        //timerExample();
        //vfsExample();

        writeToBinFile();
        //readFromBinFile();

        //reflectionExample();
        //saxExample();
    }

    private static void saxExample() {
        SerializationObject object = (SerializationObject) ReadXMLFileSAX.readXML("test.xml");
        if (object != null)
            System.out.append(object.toString() + '\n');
    }


    private static void reflectionExample() {
        SerializationObject object = (SerializationObject) ReflectionHelper.createInstance("main.SerializationObject");
        System.out.append(object.toString() + '\n');

        ReflectionHelper.setFieldValue(object, "name", "Kaylee");
        ReflectionHelper.setFieldValue(object, "age", "24");
        System.out.append(object.toString() + '\n');
    }

    private static void readFromBinFile() {
        System.out.append("Read from bin file\n");
        Object object = ObjectWriter.read("zoe.bin");
        System.out.append(object.toString() + '\n');
    }

    private static void writeToBinFile() {
        SerializationObject object = new SerializationObject("Zoe", 31);
        ObjectWriter.write(object, "zoe.bin");
    }

    private static void vfsExample() {
        VFS vfs = new VFSImpl("");
        System.out.append("Current path: " + vfs.getAbsolutePath(""));
        Iterator<String> iter = vfs.getIterator("./");
        while (iter.hasNext()) {
            System.out.append(iter.next() + "\n");
        }
    }

    private static void timerExample() {
        System.out.append("ENGLISH full time: " + TimeHelper.getUserTimeFull(Locale.ENGLISH) + '\n');
        final int timeMs = 10000;
        TimeService.instance().start();
        TimeService.instance().scheduleTask(new TimerTask() {
            public void run() {
                System.out.append("Timer run!\n");
                System.out.append("ENGLISH full time: " + TimeHelper.getUserTimeFull(Locale.ENGLISH) + '\n');
                TimeService.instance().stop();
            }

        }, timeMs);
    }

    private static void randomExample() {
        Random rnd = new Random();
        System.out.append("R0: " + rnd.nextInt(100) + '\n');
        System.out.append("R1: " + rnd.nextInt(100) + '\n');
        System.out.append("R2: " + rnd.nextInt(100) + '\n');
        System.out.append('\n');

        Random rndOnLong = new Random(100500L);
        System.out.append("R(100500L)0: " + rndOnLong.nextInt(100) + '\n');
        System.out.append("R(100500L)1: " + rndOnLong.nextInt(100) + '\n');
        System.out.append("R(100500L)2: " + rndOnLong.nextInt(100) + '\n');
        System.out.append('\n');

        Random rndOnTime = new Random(TimeHelper.getTimeInMs());
        System.out.append("R(Time)0: " + rndOnTime.nextInt(100) + '\n');
        System.out.append("R(Time)1: " + rndOnTime.nextInt(100) + '\n');
        System.out.append("R(Time)2: " + rndOnTime.nextInt(100) + '\n');
        System.out.append('\n');

        System.out.append("Math.random(): " + Math.random() + '\n');
    }
}
