package com.panda.benchmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * @author panda
 * created at 2021/7/31 8:55 下午
 */
@RunWith(AndroidJUnit4.class)
public class InflaterBenchmark {
	@Rule
	public BenchmarkRule benchmarkRule = new BenchmarkRule();

	@Test
	public void simpleViewInflate() {
		Context context = ApplicationProvider.getApplicationContext();
		BenchmarkState state = benchmarkRule.getState();
		LayoutInflater inflater = LayoutInflater.from(context);
		FrameLayout root = new FrameLayout(context);
		while (state.keepRunning()) {
			inflater.inflate(R.layout.test_simple_view, root, false);
		}
	}
}