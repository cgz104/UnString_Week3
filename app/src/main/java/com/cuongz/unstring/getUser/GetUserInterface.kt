package com.cuongz.unstring.getUser

interface GetUserInterface {
    interface Presenter{
        fun userLogIn(token: String?, username: String?, password: String?)
    }
}