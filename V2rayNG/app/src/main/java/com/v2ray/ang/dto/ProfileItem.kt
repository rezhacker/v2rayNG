package com.v2ray.ang.dto

import com.v2ray.ang.AppConfig.TAG_BLOCKED
import com.v2ray.ang.AppConfig.TAG_DIRECT
import com.v2ray.ang.AppConfig.TAG_PROXY
import com.v2ray.ang.util.Utils

data class ProfileItem(
    val configVersion: Int = 4,
    val configType: EConfigType,
    var subscriptionId: String = "",
    var addedTime: Long = System.currentTimeMillis(),

    var remarks: String = "",
    var server: String? = null,
    var serverPort: String? = null,

    var password: String? = null,
    var method: String? = null,
    var flow: String? = null,
    var username: String? = null,

    var network: String? = null,
    var headerType: String? = null,
    var host: String? = null,
    var path: String? = null,
    var seed: String? = null,
    var quicSecurity: String? = null,
    var quicKey: String? = null,
    var mode: String? = null,
    var serviceName: String? = null,
    var authority: String? = null,

    var security: String? = null,
    var sni: String? = null,
    var alpn: String? = null,
    var fingerPrint: String? = null,
    var insecure: Boolean? = null,

    var publicKey: String? = null,
    var shortId: String? = null,
    var spiderX: String? = null,

    var secretKey: String? = null,
    var localAddress: String? = null,
    var reserved: String? = null,
    var mtu: Int? = null,

    var obfsPassword: String? = null,
    var portHopping: String? = null,
    var portHoppingInterval: String? = null,
    var pinSHA256: String? = null,

    ) {
    companion object {
        fun create(configType: EConfigType): ProfileItem {
            return ProfileItem(configType = configType)
        }
    }

    fun getAllOutboundTags(): MutableList<String> {
        return mutableListOf(TAG_PROXY, TAG_DIRECT, TAG_BLOCKED)
    }

    fun getServerAddressAndPort(): String {
        return Utils.getIpv6Address(server) + ":" + serverPort
    }

    fun getKeyProperty(): ProfileItem {
        val copy = this.copy()
        copy.subscriptionId = ""
        copy.addedTime = 0L
        return copy
    }
}