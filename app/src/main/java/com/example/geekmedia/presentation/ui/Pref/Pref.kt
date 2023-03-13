package com.example.geekmedia.presentation.ui.Pref

import android.content.Context
import android.content.SharedPreferences
import androidx.room.*
import java.io.Serializable
import android.content.Context.MODE_PRIVATE



@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var title:String? = null,
    var description:String? = null,
) : Serializable


@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id  DESC")
    fun getAllTask(): List<Task>
    @Insert
    fun insert(task: Task)
    @Delete
    fun delete(task: Task)
    @Update
    fun update(task: Task)

}

@Database(entities = [Task::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun taskDao():TaskDao
}


class Pref(private val context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("pref_name",
        Context.MODE_PRIVATE)
    fun getImage() : String? {
        return pref.getString(PREF_IMAGE_PROFILE, "")
    }
        fun saveImage(image: String){
            pref.edit().putString(PREF_IMAGE_PROFILE, image).apply()
        }

    companion object{
        private const val PREF_IMAGE_PROFILE = "image"
    }
}