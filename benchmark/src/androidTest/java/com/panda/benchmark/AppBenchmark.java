package com.panda.benchmark;

import android.content.Context;
import android.util.Log;

import com.panda.benchmarktest.SpTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

/**
 * Benchmark, which will execute on an Android device.
 * <p>
 * The while loop will measure the contents of the loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class AppBenchmark {

	@Rule
	public BenchmarkRule mBenchmarkRule = new BenchmarkRule();
	SpTest spTest;
	String data = "";

	@Before
	public void setUp() {
		Context context = ApplicationProvider.getApplicationContext();
		spTest = new SpTest(context);
		for (int i = 0; i < 100; i++) {
			data += "abc12";
		}
	}

	@Test
	public void save() {
		final BenchmarkState state = mBenchmarkRule.getState();
		while (state.keepRunning()) {
			spTest.save(data);
		}
	}

	@Test
	public void get() {
		final BenchmarkState state = mBenchmarkRule.getState();
		while (state.keepRunning()) {
			spTest.get();
		}
	}
}