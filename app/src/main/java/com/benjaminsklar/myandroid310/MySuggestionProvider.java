package com.benjaminsklar.myandroid310;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class MySuggestionProvider extends ContentProvider {

    String [] data;
    public static final String [] columnNames = {BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1, SearchManager.SUGGEST_COLUMN_INTENT_DATA};
    public MySuggestionProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        data = getContext().getResources().getStringArray(R.array.states);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        MatrixCursor cursor = new MatrixCursor(columnNames);
        String searchPrefix = uri.getLastPathSegment();

        int i;
        String stateData;

        for (i = 0; i < data.length; i++) {
            stateData = data[i];
            String statePrefix = stateData.substring(0, searchPrefix.length());
            if (statePrefix.equalsIgnoreCase(searchPrefix)) {
                MatrixCursor.RowBuilder rowBuilder = cursor.newRow();
                rowBuilder.add(i);
                rowBuilder.add(stateData);
                rowBuilder.add(stateData);
            }
        }

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
