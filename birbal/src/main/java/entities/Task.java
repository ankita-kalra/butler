package entities;

import constants.ComputeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by shreenath on 11/1/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String name;
    private String taskId;
    private String dependentTaskId;
    private Long duration;
    private Status status;
    private Long staticScore;
    private Integer frequency;
    private Timestamp deadline;
    private TimePeriod temporalAffinity;
    private String spatialAffinity;

    public String toString() {
        return name + "-" +
                taskId + "-" +
                dependentTaskId + "-" +
                duration + "-" +
                status + "-" +
                staticScore + "-" +
                frequency + "-" +
                deadline + "-" +
                spatialAffinity;
    }


    public static class TaskMapper implements ResultSetMapper<Task> {

        @Override
        public Task map(int i, ResultSet r, StatementContext sc) throws SQLException {
            TimePeriod timePeriod = new TimePeriod(r.getTime("startTimeOfTheDay"), r.getTime("endTimeOfTheDay"));
            return new Task(r.getString("name"),
                    r.getString("taskId"),
                    r.getString("dependentTaskId"),
                    r.getLong("durationMins")* ComputeConstants.MINS_2_MS,
                    Status.valueOf(r.getString("status")),
                    r.getLong("staticScore"),
                    r.getInt("frequency"),
                    r.getTimestamp("deadline"),
                    timePeriod,
                    r.getString("places")
                    );
        }
    }
}
