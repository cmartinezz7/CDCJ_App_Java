package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okio.Okio;

class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    public boolean canHandleRequest(Request data) {
        return "file".equals(data.uri.getScheme());
    }

    public RequestHandler.Result load(Request request, int networkPolicy) throws IOException {
        return new RequestHandler.Result((Bitmap) null, Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK, getFileExifRotation(request.uri));
    }

    static int getFileExifRotation(Uri uri) throws IOException {
        return new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
    }
}
