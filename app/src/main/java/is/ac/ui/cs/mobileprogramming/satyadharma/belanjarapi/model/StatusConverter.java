package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.TypeConverter;

public class StatusConverter {
    @TypeConverter
    public static int fromStatus (Status status){
        return status.ordinal();
    }

    @TypeConverter
    public static Status toStatus (int ord){
        return (Status.values()[ord]);
    }
}
