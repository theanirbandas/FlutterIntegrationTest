package com.example.flutterintegration;

import android.app.Application;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class MyApplication extends Application {

	private String mEngineId = "flutter_engine_1";

	@Override
	public void onCreate() {
		super.onCreate();
		// Instantiate a FlutterEngine.
		FlutterEngine flutterEngine = new FlutterEngine(this);

		flutterEngine.getNavigationChannel().setInitialRoute("/increment");

		// Start executing Dart code to pre-warm the FlutterEngine.
		flutterEngine.getDartExecutor().executeDartEntrypoint(
				DartExecutor.DartEntrypoint.createDefault()
		);

		// Cache the FlutterEngine to be used by FlutterActivity.
		FlutterEngineCache
				.getInstance()
				.put(mEngineId, flutterEngine);
	}
}
