package com.syoon.shoppi.repository.home

import com.syoon.shoppi.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}