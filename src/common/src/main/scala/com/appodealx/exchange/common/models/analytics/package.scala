package com.appodealx.exchange.common.models

import cats.syntax.option._
import com.appodealx.exchange.common.models.rtb._


package object analytics {

  implicit class AuctionAnalyticsEntityHelper(e: AuctionAnalyticEntity) {
    def toKafkaBid: KafkaBid = KafkaBid(
      timestamp = e.timestamp,
      bidRequestId = e.bidRequestId,
      adType = e.adType,
      adSize = e.adSize,
      adSpaceId = e.adSpaceId,
      sspAuctionType = e.sspAuctionType,

      // App
      app = e.appExternalId.map(_.toString + e.appName.map("|" + _).getOrElse("")),
      appExternalId = e.appExternalId.map(_.toString),
      appPublisherExternalId = e.appPublisherExternalId.map(_.toString),
      appName = e.appName,
      appPublisherName = e.appPublisherName,
      appBundle = e.appBundle,
      appCategories = e.appCategories,
      appVersion = e.appVersion,

      // Site
      siteId = e.siteId,
      sitePublisherId = e.sitePublisherId,
      siteName = e.siteName,
      sitePublisherName = e.sitePublisherName,
      siteDomain = e.siteDomain,
      siteCategories = e.siteCategories,
      siteSectionCategories = e.siteSectionCategories,
      sitePageCategories = e.sitePageCategories,
      sitePage = e.sitePage,
      siteRef = e.siteRef,
      siteSearch = e.siteSearch,
      siteMobile = e.siteMobile,
      sitePrivacypolicy = e.sitePrivacypolicy,
      siteKeywords = e.siteKeywords,

      sellerId = e.sellerId,
      sellerName = e.sellerName,

      agencyId = e.bidderAgencyId,
      agencyExternalId = e.bidderAgencyExternalId,
      agencyName = e.bidderAgencyName,
      bidderId = e.bidderId,
      bidderName = e.bidderName,
      bidderAdProfileId = e.bidderAdProfileId,
      bidderRtbVersion = e.bidderRtbVersion.some,
      bidFloorLevel = e.bidFloorLevel,
      bidStatus = e.bidStatus,
      bidAdomain = e.bidAdomain,
      bidBundle = e.bidBundle,
      bidCategories = e.bidCategories,
      bidAttributes = e.bidAttributes.map(_.map(_.prettyValue)),
      bidImpressionUrl = e.bidImpressionUrl,
      bidCampaignId = e.bidCampaignId,
      bidCreativeId = e.bidCreativeId,
      bidCreativeRating = e.bidCreativeRating,
      bidNurlDomain = e.bidNurlDomain,
      bidNurlStatus = e.bidNurlStatus,
      bidHasAdm = e.bidHasAdm,
      bidPriceLevel = e.bidPriceLevel,
      clearingPriceLevel = e.clearingPriceLevel,
      clearingPrice = e.clearingPrice,
      requestBlockedCategories = e.requestBlockedCategories,
      requestBlockedAdvertisers = e.requestBlockedAdvertisers,
      requestBlockedAttributes = e.requestBlockedAttributes.map(_.map(_.prettyValue)),
      deviceOs = e.deviceOs,
      deviceOsVersion = e.deviceOsVersion,
      deviceCarrier = e.deviceCarrier,
      deviceMake = e.deviceMake,
      deviceModel = e.deviceModel,
      deviceType = e.deviceType,
      deviceIfa = e.deviceIfa,
      deviceIp = e.deviceIp,
      deviceIpV6 = e.deviceIpV6,
      deviceConnectionType = e.deviceConnectionType.map(_.prettyValue),
      displayManager = e.displayManager, // For rtb auction: `dm` = `mediation sdk`
      displayManagerVersion = e.displayManagerVersion,
      mediationSdkName = e.mediationSdkName,
      mediationSdkVersion = e.mediationSdkVersion,
      country = e.country,
      coppa = e.coppa,
      test = e.test,
      adNetwork = e.adNetwork.some,
      adNetworkName = e.adNetworkName,
      adNetworkPlacementId = e.adNetworkPlacementId,
      cached = e.isCached.some,
      isUnderPrice = e.isUnderPrice.some,
      sessionNumber = e.sessionNumber,
      impressionNumber = e.impressionNumber,
      ipLocationService = e.ipLocationService.map(_.prettyValue),
      dcid = e.dcid)

    def toKafkaBidRequest: KafkaBidRequest = KafkaBidRequest(
      mediationId = e.mediationId,
      bidRequestId = e.bidRequestId,
      timestamp = e.timestamp,
      adType = e.adType,
      agency = e.bidderAgencyExternalId.map(baeId => e.bidderAgencyName + "|" + baeId.value.toString + e.bidderAgencyId.map("|" + _.value.toString).getOrElse("")),
      bidder = e.bidderId.map(id => id.value.toString + "|" + e.bidderName),
      adProfileId = e.bidderAdProfileId,
      adSpaceId = e.adSpaceId,
      bidStatus = e.bidStatus,
      bidResponseStatus = e.bidResponseStatus,
      bidPriceLevel = e.bidPriceLevel.some,
      country = e.country,
      platform = e.deviceOs,
      osVersion = e.deviceOsVersion,
      dm = e.displayManager,
      dmVersion = e.displayManagerVersion,
      publisherId = e.appPublisherExternalId.map(_.toString).orElse(e.sitePublisherId),
      sellerId = e.sellerId,
      sellerName = e.sellerName,
      app = e.appExternalId.map(_.toString + e.appName.map("|" + _).getOrElse("")),
      appBundle = e.appBundle.some,
      siteDomain = e.siteDomain,
      ifa = e.deviceIfa,
      adNetwork = e.adNetwork.some,
      adNetworkName = e.adNetworkName,
      adNetworkPlacementId = e.adNetworkPlacementId,
      dcid = e.dcid
    )
  }

}