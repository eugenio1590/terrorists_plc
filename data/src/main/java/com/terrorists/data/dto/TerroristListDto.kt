package com.terrorists.data.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "sdnList", strict = false)
class TerroristListDto @JvmOverloads constructor(
    @field: ElementList(inline = true)
    var terrorists: List<TerroristDto>? = null
)