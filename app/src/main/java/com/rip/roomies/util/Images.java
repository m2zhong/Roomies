package com.rip.roomies.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.rip.roomies.R;

import java.util.logging.Logger;

/**
 * This class keeps track of all the images we need in our app.
 */
public class Images {
	private static final Logger log = Logger.getLogger(Images.class.getName());

	/**
	 * Get a bitmap of the desired resource that is scaled down to the requested size so that
	 * less memory is used and does not cause significant overhead on the device.
	 * @param res The resources of the activity
	 * @param id The id of the resource to get bitmap of
	 * @param width The desired width of the resource
	 * @param height The desired height of the resource
	 * @return The resultant bitmap
	 */
	public static Bitmap getScaledDownBitmap(Resources res, int id, int width, int height) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, id, options);

		options.inSampleSize = getSampleSize(options, width, height);
		log.info("Sample Size: " + options.inSampleSize);

		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, id, options);
	}

	/**
	 * Get the sample size based off the options object and the desired width/height.
	 * @param options The options that contains image original size
	 * @param reqWidth The desired width of the image
	 * @param reqHeight The desired height of the image
	 * @return The inSampleSize that can be used by BitmapFactory to scale down image
	 */
	private static int getSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}
}
