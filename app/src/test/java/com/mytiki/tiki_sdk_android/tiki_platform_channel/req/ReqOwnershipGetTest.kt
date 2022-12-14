/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */
package com.mytiki.tiki_sdk_android.tiki_platform_channel.req

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Assert
import org.junit.Test

class ReqOwnershipGetTest {
    @Test
    fun encode_ReqOwnershipGet_from_JSON() {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ReqOwnershipGet> = moshi.adapter(ReqOwnershipGet::class.java)
        val json = "{\"source\":\"source\"}"
        val req = adapter.fromJson(json)
        Assert.assertEquals(req!!.source, "source")
    }

    @Test
    fun encode_ReqOwnershipGet_to_JSON() {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ReqOwnershipGet> = moshi.adapter(ReqOwnershipGet::class.java)
        val req = ReqOwnershipGet("source")
        val json = adapter.toJson(req)
        Assert.assertEquals("{\"source\":\"source\"}", json)
    }
}