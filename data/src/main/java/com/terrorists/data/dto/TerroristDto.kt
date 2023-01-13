package com.terrorists.data.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "sdnEntry", strict = false)
class TerroristDto @JvmOverloads constructor(
    @field: Element(name = "firstName", required = false)
    var firstName: String? = null,
    @field: Element(name = "lastName")
    var lastName: String? = null,
    @field: ElementList(name = "dateOfBirthList", required = false)
    var dateOfBirthList: List<DateOfBirth>? = null,
    @field: ElementList(name = "placeOfBirthList", required = false)
    var placeOfBirthList: List<PlaceOfBirth>? = null
)

@Root(name = "dateOfBirthItem", strict = false)
class DateOfBirth @JvmOverloads constructor(
    @field: Element(name = "dateOfBirth")
    var date: String? = null
)

@Root(name = "placeOfBirthItem", strict = false)
class PlaceOfBirth @JvmOverloads constructor(
    @field: Element(name = "placeOfBirth")
    var place: String? = null
)