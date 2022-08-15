package com.syoon.shoppi.repository

import com.syoon.shoppi.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}