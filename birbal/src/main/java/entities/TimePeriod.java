package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by shreenath on 11/1/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimePeriod {
    private Long startTime;
    private Long endTime;

    public boolean contains(Long time) {
        return time>=startTime && time<=endTime;
    }
}