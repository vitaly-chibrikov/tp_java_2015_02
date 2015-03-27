package vfs;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class VFSImpl implements VFS {

    private String root;

    public VFSImpl(String root) {
        this.root = root;
    }


    public boolean isDirectory(String path) {
        return new File(root + path).isDirectory();
    }


    public Iterator<String> getIterator(String startDir) {
        return new FileIterator(startDir);
    }

    private class FileIterator implements Iterator<String> {

        private Queue<File> files = new LinkedList<File>();

        public FileIterator(String path) {
            files.add(new File(root + path));
        }

        public boolean hasNext() {
            return !files.isEmpty();
        }

        public String next() {
            File file = files.peek();
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    files.add(subFile);
                }
            }

            return files.poll().getAbsolutePath();
        }

        public void remove() {

        }

    }

    @Override
    public String getAbsolutePath(String file) {
        return new File(root + file).getAbsolutePath();
    }


    @Override
    public boolean isExist(String path) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public byte[] getBytes(String file) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String getUFT8Text(String file) {
        // TODO Auto-generated method stub
        return null;
    }

}
