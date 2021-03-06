package com.ando.jetpack.room.dao

import androidx.lifecycle.LiveData
import com.ando.jetpack.room.User

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class UserRepository(private val userDao: UserDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allUsers: LiveData<List<User>> = userDao.getAll()

    suspend fun insert(user: User) {
        userDao.add(user)
    }
}