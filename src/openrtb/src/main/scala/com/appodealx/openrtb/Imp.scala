package com.appodealx.openrtb

case class Imp(id: String,
               metric: Option[List[Metric]] = None,
               banner: Option[Banner] = None,
               video: Option[Video] = None,
               audio: Option[Audio] = None,
               native: Option[Native] = None,
               displaymanager: Option[String] = None,
               displaymanagerver: Option[String] = None,
               instl: Option[Boolean] = Some(false),
               tagid: Option[String] = None,
               bidfloor: Option[Double] = Some(0.0),
               bidfloorcur: Option[String] = Some("USD"),
               clickbrowser: Option[Int] = None,
               secure: Option[Boolean] = None,
               iframebuster: Option[List[String]] = None,
               pmp: Option[Pmp] = None,
               exp: Option[Int] = None,
               ext: Option[Json] = None)