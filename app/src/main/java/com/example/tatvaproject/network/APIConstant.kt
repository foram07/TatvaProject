package com.example.tatvaproject.network

object APIConstant {

    //https://reqres.in/api/users?page=1
    const val BASE_URL = "https://reqres.in/api/"
    const val API_USERS = "users"
    const val PARAM_PAGE = "page"

    const val STARTING_PAGE_INDEX = 1


    const val STATUS_SUCCESS = 200
    const val STATUS_NOT_FOUND = 404
    const val STATUS_INTERNAL_SERVER_ERROR = 501
}