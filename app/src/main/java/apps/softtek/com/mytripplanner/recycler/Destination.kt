package apps.softtek.com.mytripplanner.recycler

import android.graphics.drawable.Drawable

data class Destination(
        val destinationName: String,
        val destinationDescription: String,
        val destinationImage: Int,
        var destinationID: Int
)