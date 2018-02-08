# distributeddb-jailcell
Back end service for DistributedDB that writes encrypted blocks to file

### Design
* Accepts Read, Write, or Delete commands
* JSON is posted with method type (Read | Write | Delete), hashed keys, and data blocks if Write
* On write, write all blocks to file with filenames as the keys
* On delete, delete all files with given keys as filenames
* On read, read in files from filenames and respond with JSON of just the data blocks
* TODO: Exceptions

### Auth
* TODO
