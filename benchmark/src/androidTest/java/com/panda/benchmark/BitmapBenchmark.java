package com.panda.benchmark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

/**
 * @author panda
 * created at 2021/7/31 8:55 下午
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class BitmapBenchmark {
	@Rule
	public BenchmarkRule benchmarkRule = new BenchmarkRule();
	Bitmap bitmap;
	Context context = ApplicationProvider.getApplicationContext();
	String JETPACK = "jetpack.png";

	@Before
	public void setUp() {
		try {
			InputStream inputStream = context.getAssets().open(JETPACK);
			bitmap = BitmapFactory.decodeStream(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void bitmapGetPixelBenchmark() {
		BenchmarkState state = benchmarkRule.getState();
		while (state.keepRunning()) {
			int w = bitmap.getWidth();
			int h = bitmap.getHeight();
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					bitmap.getPixel(x, y);
				}
			}
		}
	}

	@Test
	public void bitmapGetPixelsBenchmark() {
		BenchmarkState state = benchmarkRule.getState();
		while (state.keepRunning()) {
			int w = bitmap.getWidth();
			int h = bitmap.getHeight();
			int[] pixels = new int[w*h];
			bitmap.getPixels(pixels, 0, 0, 0, 0, w, h);
		}
	}
}