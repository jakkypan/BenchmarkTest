package com.panda.benchmarktest;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author panda
 * created at 2021/8/1 12:35 下午
 */
public class SpTest {
	private SharedPreferences sp;

	public SpTest(Context context) {
		sp = context.getSharedPreferences("test", MODE_PRIVATE);
	}

	public void save(String data) {
		sp.edit().putString("data", data).commit();
	}

	public void get() {
		sp.getString("data", "");
	}
}
