# Task: Duplicate File Finder in Java

## Objective
The objective of this task is to implement a Java program that identifies duplicate files in a given directory (or multiple directories). The program should detect duplicates based on three criteria: file name, file size, and CRC32 hash. By the end of this task, you should be able to identify and list all duplicate files with their paths.

## Requirements
1. **File Representation**:
    - Each file should be represented as an object with the following attributes:
        - `name`: The file's name.
        - `path`: The full path to the file.
        - `size`: The size of the file in bytes.
        - `crc32`: (Optional, to be computed later) The CRC32 hash of the file content.

2. **Duplicate Detection Process**:
    - **Step 1**: **Name Matching**
        - Create a list of all files in the specified directories.
        - Group the files by their `name`.
        - Filter out the groups where the list of paths has more than one file.
        - Output: A `Map<String, List<String>>` where the key is the file name and the value is a list of paths for files with that name.
    - **Step 2**: **Size Filtering**
        - For each group from Step 1, filter files by `size` such that only files with the same size remain.
        - Update the map to include only those files where the size matches.
        - Output: A `Map<String, List<String>>` where the key is the file name and the value is a list of paths for files with that name and size.
    - **Step 3**: **CRC32 Hash Comparison**
        - For each group from Step 2, compute the CRC32 hash for each file.
        - Compare the CRC32 hashes and keep only those files where the hash matches.
        - Final Output: A `Map<String, List<String>>` where the key is the file name and the value is a list of paths for files with the same name, size, and CRC32 hash.

3. **Implementation Details**:
    - The program should be able to traverse directories recursively to find all files.
    - Use Java's built-in `java.util.zip.CRC32` class for CRC32 computation.
    - Consider edge cases such as files with the same name but different sizes, files with different names but identical content, etc.
    - You may use `java.nio.file` package for file operations.

4. **Expected Output**:
    - The program should print or return a `Map<String, List<String>>` containing the names of the duplicate files and their corresponding paths.

## Example
Given the following files in a directory:
```
file1.txt (Path: /folder1/file1.txt, Size: 1024 bytes)
file2.txt (Path: /folder2/file2.txt, Size: 1024 bytes)
file3.txt (Path: /folder1/file3.txt, Size: 2048 bytes)
file1.txt (Path: /folder2/file1.txt, Size: 1024 bytes)
file4.txt (Path: /folder1/file4.txt, Size: 1024 bytes)
```

The program should output something like:
```
{
    "file1.txt": ["/folder1/file1.txt", "/folder2/file1.txt"],
    "file2.txt": ["/folder2/file2.txt"],
    "file4.txt": ["/folder1/file4.txt"]
}
```

## Deliverables
- A Java program that implements the above functionality.
- A brief report explaining how the solution works, including any challenges faced during implementation.
- Test cases demonstrating the program's effectiveness in identifying duplicate files.

## Implementation Hints
1. **File Object Representation**:
   ```
   class FileInfo {
       String name;
       String path;
       long size;
       long crc32;

       // Constructor, Getters, and Setters
   }
   ```

2. **Directory Traversal**:
    - Use `Files.walk()` to traverse directories recursively.
    - Collect files in a list of `FileInfo` objects.

3. **CRC32 Calculation**:
   ```
   CRC32 crc = new CRC32();
   byte[] bytes = Files.readAllBytes(Paths.get(fileInfo.getPath()));
   crc.update(bytes);
   fileInfo.setCrc32(crc.getValue());
   ```

4. **Grouping Files**:
    - Use a `Map<String, List<FileInfo>>` to group files by name initially, then by size, and finally by CRC32.

5. **Output**:
    - The final output should be a map of duplicate file names and their respective paths.

## Additional Considerations
- Optimize the program for performance, especially when dealing with large directories.
- Provide clear documentation and comments in the code.

---

This task is designed to test your understanding of file handling, hashing, and data structures in Java. Good luck!
