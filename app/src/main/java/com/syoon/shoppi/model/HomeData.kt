package com.syoon.shoppi.model

import com.google.gson.annotations.SerializedName
import com.syoon.shoppi.Banner

data class HomeData(
    val title: Title,
    @SerializedName("top_banners")
    val topBanners: List<Banner>
)
