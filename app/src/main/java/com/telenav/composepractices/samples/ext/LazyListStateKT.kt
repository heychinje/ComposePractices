package com.telenav.composepractices.samples.ext

import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState

val LazyListState.firstVisibleItem: LazyListItemInfo? get() = layoutInfo.visibleItemsInfo.firstOrNull()
val LazyListState.lastVisibleItem: LazyListItemInfo? get() = layoutInfo.visibleItemsInfo.lastOrNull()

val LazyListState.isReachedStart: Boolean get() = firstVisibleItemIndex == 0 && firstVisibleItemScrollOffset == 0
val LazyListState.isReachedEnd: Boolean
    get() = lastVisibleItem?.run {
        index == (this@isReachedEnd.layoutInfo.totalItemsCount - 1) && (offset + size + this@isReachedEnd.layoutInfo.beforeContentPadding) == this@isReachedEnd.layoutInfo.viewportEndOffset
    } ?: false
