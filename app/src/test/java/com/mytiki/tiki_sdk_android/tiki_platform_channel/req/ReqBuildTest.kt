/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */
package com.mytiki.tiki_sdk_android.tiki_platform_channel.req

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Assert
import org.junit.Test

class ReqBuildTest {
    @Test
    fun encode_ReqBuild_from_JSON() {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ReqBuild> = moshi.adapter(ReqBuild::class.java)
        val json = "{\"apiId\":\"apiId\",\"origin\":\"origin\"}"
        val reqBuild = adapter.fromJson(json)
        Assert.assertEquals("apiId", reqBuild?.apiId)
        Assert.assertEquals("origin", reqBuild?.origin)
        Assert.assertNull(reqBuild!!.address)

    }

    @Test
    fun encode_ReqBuild_to_JSON() {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ReqBuild> = moshi.adapter(ReqBuild::class.java)
        val req = ReqBuild("apiId", "origin")
        val json = adapter.toJson(req)
        Assert.assertEquals(
            "{\"apiId\":\"apiId\",\"origin\":\"origin\"}",
            json
        )
    }
}