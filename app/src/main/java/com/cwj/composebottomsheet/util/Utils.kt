package com.cwj.composebottomsheet.util

import android.content.Context
import android.widget.Toast

fun makeToast(ctx: Context, msg: String) {
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
}