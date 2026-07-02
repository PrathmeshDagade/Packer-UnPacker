# Packer-UnPacker



A simple Java project that demonstrates how to pack multiple files from a directory into a single file and later unpack them back to their original form .
 
This project is useful for understanding:
- File Handling in Java
- FileInputStream & FileOutputStream
- Binary File Operations
- Custom File Header Design
- Directory Traversal
- Object-Oriented Programming Concepts

---

 Features

- Pack all files from a directory into one packed file.
- Restore (unpack) all files from the packed file.
- Stores file metadata (name and size) before file contents.
- Simple command-line interface.
- Pure Java implementation (No external libraries).

---

 Project Structure



├── Packer.java
└── Unpacker.java


---

 How It Works

 Packing Process

For every file inside the selected directory:

1. Read the file name.
2. Read the file size.
3. Create a 100-byte header containing:
   - File Name
   - File Size
4. Write the header into the packed file.
5. Append the actual file data.

Packed File Format:

------------------------------------------------------
| 100 Bytes Header | File Data |
------------------------------------------------------
| 100 Bytes Header | File Data |
------------------------------------------------------
| 100 Bytes Header | File Data |
------------------------------------------------------
```

Header Format:

<FileName> <FileSize>

Example:


notes.txt 2048


The remaining bytes of the 100-byte header are padded with spaces.

---

Unpacking Process

The unpacker:

1. Reads the first 100 bytes.
2. Extracts:
   - File Name
   - File Size
3. Creates a new file.
4. Reads exactly the number of bytes specified.
5. Writes them into the newly created file.
6. Repeats until the packed file ends.

---

 Compilation

Compile both files:

 bash
javac Packer.java
javac Unpacker.java
```

---

Running

Pack Files

bash
java Packer


Example:


Enter Directory Name to pack a file
MyFolder

Enter PackerFile name to pack the files
PackedFile.pack


---

 Unpack Files

bash
java Unpacker


Example:


Enter packed file name to unpack

PackedFile.pack


---

 Technologies Used

- Java
- FileInputStream
- FileOutputStream
- BufferedReader
- Scanner
- OOP

---

 Concepts Covered

- Java File Handling
- Streams
- Binary Files
- Custom File Format
- Header Metadata
- Directory Operations
- Exception Handling
- Object-Oriented Programming

---

 Author

Prathmesh Dagade



