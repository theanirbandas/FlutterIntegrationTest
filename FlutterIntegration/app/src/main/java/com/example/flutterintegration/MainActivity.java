package com.example.flutterintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.incrementer).setOnClickListener(v -> startActivity(
				FlutterActivity
						.withCachedEngine("flutter_engine_1")
						.backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
						.build(MainActivity.this)
		));

		findViewById(R.id.decrementer).setOnClickListener(v -> startActivity(
				FlutterActivity
						.withNewEngine()
						.initialRoute("/decrement")
						.build(MainActivity.this)
		));
	}
}