/*
 * Copyright © Marc Auberer 2020. All rights reserved
 */

package com.chillibits.simplesettings.item

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes

class SimpleInputPreference(
    iconSpaceReservedByDefault: Boolean
): SimplePreference(iconSpaceReservedByDefault) {
    // Attributes
    var defaultValue = ""
    var dialogTitle = ""
    var dialogMessage: String? = null
    @DrawableRes
    var dialogIconRes = 0
    var dialogIcon: Drawable? = null
    @LayoutRes
    var dialogLayoutRes = 0
    var simpleSummaryProvider = false
}