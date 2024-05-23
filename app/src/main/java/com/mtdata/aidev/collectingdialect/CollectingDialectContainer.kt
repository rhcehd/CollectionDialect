package com.mtdata.aidev.collectingdialect

import com.mtdata.aidev.collectingdialect.data.remote.FakeCollectingDialectNetwork
import com.mtdata.aidev.collectingdialect.data.repository.impl.RecordRepositoryImpl
import com.mtdata.aidev.collectingdialect.data.repository.impl.UserRepositoryImpl

object CollectingDialectContainer {
    val collectingDialectNetworkDataSource = FakeCollectingDialectNetwork()
    val userRepository = UserRepositoryImpl(collectingDialectNetworkDataSource)
    val recordRepository = RecordRepositoryImpl(collectingDialectNetworkDataSource)
}