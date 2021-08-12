package practice;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

}
class LearnEnum {
    Day day;

    LearnEnum (Day day){
        this.day = day;
    }
    public void dayIsLike(){
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad");
                break;
            case TUESDAY:
                System.out.println("Tuesdays are ok");
                break;
            case WEDNESDAY:
                System.out.println("wednesdays are fine");
                break;
            case THURSDAY:
                System.out.println("Thursdays are hot");
                break;
            case FRIDAY:
                System.out.println("Friday are good");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are fun");

                break;
            default:
                System.out.println("Midbweek are so so");
                break;

        }
    }


    }

