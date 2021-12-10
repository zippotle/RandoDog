# Random Dog Photo App

I am getting the following errors:

## DogImageApp.kt

I am trying to import the function getDatabase and used the import statement: 
```bash
import com.yah.ph3project3.data.ImageDatabase
```
Which is not working. I also tried:

```
import com.yah.ph3project3.data.ImageDatabase.getDatabase

```
## ImageDao.kt

 
```bash
    @Query("Select * FROM images")
    fun getAllImages(): Flow1<List<DataImageData>>
```
I'm getting the error:

```
No type arguments expected for class Flow

```
