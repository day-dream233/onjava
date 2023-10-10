package t17;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileSystemDemo {
    public static void main(String[] args) {
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        FileSystem fileSystem = FileSystems.getDefault();
        fileSystem.getFileStores().forEach(System.out::println);
        System.out.println();
        fileSystem.getRootDirectories().forEach(System.out::println);
        System.out.println("fileSystem.getSeparator() = " + fileSystem.getSeparator());
        System.out.println("fileSystem.getUserPrincipalLookupService() = " + fileSystem.getUserPrincipalLookupService());
        System.out.println("fileSystem.isOpen() = " + fileSystem.isOpen());
        System.out.println("fileSystem.isReadOnly() = " + fileSystem.isReadOnly());
        System.out.println("fileSystem.supportedFileAttributeViews() = " + fileSystem.supportedFileAttributeViews());

    }
}
