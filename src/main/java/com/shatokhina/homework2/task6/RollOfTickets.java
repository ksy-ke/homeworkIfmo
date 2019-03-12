package com.shatokhina.homework2.task6;

/*
В городе N проезд в трамвае осуществляется по бумажным отрывным билетам.
Каждую неделю трамвайное депо заказывает в местной типографии рулон билетов
с номерами от 000001 до 999999. «Счастливым» считается билетик у которого сумма
первых трёх цифр номера равна сумме последних трёх цифр, как, например, в билетах
с номерами 003102 или 567576. Трамвайное депо решило подарить сувенир обладателю
каждого счастливого билета и теперь раздумывает, как много сувениров потребуется.
С помощью программы подсчитайте сколько счастливых билетов в одном рулоне?
*/

import java.util.HashMap;
import java.util.Map;

public class RollOfTickets {
    public static int luckyTickets() {
        int sumRepeat = 0;

        Map<Integer, Integer> repeatCount = new HashMap<>();
        for (int key = 1; key <= 27; key++) { repeatCount.put(key, 0); }

        for (int number = 1; number <= 999; number++) {
            int current = number;
            int sum = 0;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }
            repeatCount.put(sum,
                    repeatCount.get(sum) + 1);
        }

        for (int value : repeatCount.values()) { sumRepeat += Math.pow(value, 2); }

        return sumRepeat;
    }
}