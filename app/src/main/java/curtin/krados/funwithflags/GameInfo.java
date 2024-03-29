package curtin.krados.funwithflags;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import curtin.krados.funwithflags.questions.*;

public class GameInfo {
    //Singleton
    private static GameInfo sInstance;
    public static GameInfo getInstance() {
        if (sInstance == null) {
            sInstance = new GameInfo();
        }
        return sInstance;
    }

    public static final int SPECIAL_BONUS = 10;

    private MutableLiveData<Integer> mPoints;
    private int mTargetPoints;
    private boolean mButtonNeeded; //Determines the presence of a back button in status bar
    private List<Country> mCountries;
    private Country currentCountry;
    private Question currentQuestion;
    private int specialPoints;
    private boolean ended;

    //Constructor
    private GameInfo() {
        mPoints = new MutableLiveData<>();
        mPoints.setValue(2);
        mTargetPoints = 0;
        mCountries = new ArrayList<>();
        mButtonNeeded = false;
        specialPoints = 0;
        ended = false;
        createCountries();
    }

    //Accessors
    public LiveData<Integer> getPoints() {
        return mPoints;
    }
    public int getTargetPoints() {
        return mTargetPoints;
    }
    public boolean isButtonNeeded() {
        return mButtonNeeded;
    }
    public List<Country> getCountries() {
        return mCountries;
    }
    public Country getCurrentCountry() {
        return currentCountry;
    }
    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    public int getSpecialPoints() {
        return specialPoints;
    }
    public boolean isEnded() {
        return ended;
    }

    //Mutators
    public void setPoints(int points) {
        mPoints.setValue(points);
    }
    public void setTargetPoints(int targetPoints) {
        mTargetPoints = targetPoints;
    }
    public void setButtonNeeded(boolean buttonNeeded) {
        mButtonNeeded = buttonNeeded;
    }
    public void setCurrentCountry(Country currentCountry) {
        this.currentCountry = currentCountry;
    }
    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
    public void setSpecialPoints(int specialPoints) {
        this.specialPoints = specialPoints;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    //Hardcoded implementation of country names, flags and questions
    private void createCountries() {
        //Antigua and Barbuda
        Question[] agQ = new Question[] {
            new TrueFalseQ("St. John's is both the capital city and largest city of Antigua and Barbuda.",
                    false, true),
            new FourNumQ("At what order of magnitude is Antigua and Barbuda's GDP in USD?",
                    new String[] {"5 (100,000)", "6 (1,000,000)", "7 (10,000,000)", "8 (100,000,000)"},
                    false, 2),
            new ThreeNumQ("What is the separation between the islands Antigua and Barbuda?",
                    new String[] {"13km", "41km", "63km"},
                    false, 3),
            new ThreeNameQ("Which of these is not an island owned by Antigua and Barbuda?",
                    new String[] {"Green", "Long", "Rough"},
                    false, 3),
            new TrueFalseQ("The driving side of Antigua and Barbuda is on the right.",
                    false, false)
        };

        //Albania
        Question[] alQ = new Question[] {
            new ThreeNumQ("What is the GDP per capita (PPP) of Albania?",
                    new String[] {"$9,000", "$14,000", "$19,000"},
                    false, 2),
            new FourNameQ("What is the capital city of Albania?",
                    new String[] {"Durrës", "Vlorë", "Tirana", "Elbasan"},
                    false, 3),
            new TwoNameQ("What is the majority religion of Albania?",
                    new String[] {"Christianity", "Islam"},
                    false, 2),
            new TrueFalseQ("Albania was a former Yugoslav socialist republic.",
                    false, false),
            new FourNameQ("What form of government does Albania have?",
                    new String[] {"Semi-Presidential Republic", "Parliamentary Republic", "Parliamentary Constitutional Monarchy", "One-Party State"},
                    false, 2)
        };

        //Australia
        Question[] auQ = new Question[] {
            new TrueFalseQ("Australia is a unitary state.",
                    false, false),
            new FourNameQ("What form of government does Australia have?",
                    new String[] {"Semi-Presidential Republic", "Parliamentary Republic", "Parliamentary Constitutional Monarchy", "Absolute Monarchy"},
                    false, 3),
            new FourNumQ("Between 2010 and 2018 Australia had 3 elections for head of government. How many different people actually served as head of government during that same time frame?",
                    new String[] {"2", "3", "4", "5"},
                    true, 4),
            new TrueFalseQ("Excluding countries that have suffered hyperinflation, Australia has the highest nominal minimum wage in the world.",
                    false, true),
            new ThreeNumQ("How many time zones does Australia have (including daylight savings)?",
                    new String[] {"3", "4", "5"},
                    false, 3),
            new FourNameQ("Who is generally agreed to be the first European captain to discover Australia?",
                    new String[] {"Willem Janszoon", "Luís Vaz de Torres", "James Cook", "Dirk Hartog"},
                    false, 1),
            new TrueFalseQ("In the Jurassic period Australia was covered by large swathes of inland sea.",
                    false, false),
            new ThreeNumQ("How many Australian states are in the top 10 largest country subdivisions by area?",
                    new String[] {"1", "2", "3"},
                    false, 2),
            new FourNumQ("What percentage of global iron ore production comes from Australia?",
                    new String[] {"4%", "13%", "29%", "37%"},
                    false, 4),
            new TrueFalseQ("The two largest mining companies in the world by market capitalisation are headquartered in Australia.",
                    false, true)
        };

        //Azerbaijan
        Question[] azQ = new Question[] {
            new TrueFalseQ("Azerbaijan is a former Soviet socialist republic.",
                    false, true),
            new ThreeNumQ("What is the population of Azerbaijan?",
                    new String[] {"5,000,000", "10,000,000", "20,000,000"},
                    false, 2),
            new TwoNumQ("When did Azerbaijan first adopt their current flag?",
                    new String[] {"9 November 1918", "5 February 1991"},
                    false, 1),
            new FourNumQ("Azerbaijan shares a land border with how many countries?",
                    new String[] {"2", "3", "5", "7"},
                    false, 3),
            new ThreeNameQ("What is the capital and largest city of Azerbaijan?",
                    new String[] {"Baku", "Ganja", "Sumqayit"},
                    false, 1),
            new ThreeNameQ("The Nakhchivan Autonomous Republic is a/an _____ of Azerbaijan.",
                    new String[] {"Enclave", "Exclave", "Pene-Exclave (Functional Exclave)"},
                    false, 2)
        };

        //Bosnia and Herzegovina
        Question[] baQ = new Question[] {
                new TrueFalseQ("Sarajevo is both the capital city and largest city of Bosnia and Herzegovina.",
                    false, false),
                new ThreeNumQ("What is the population of Bosnia and Herzegovina?",
                    new String[] {"2,000,000", "3,300,000", "5,600,000"},
                    false, 2)
        };

        //Barbados
        Question[] bbQ = new Question[] {
                new TrueFalseQ("Bridgetown is both the capital city and largest city of Barbados.",
                    false, true),
                new ThreeNumQ("What is the population of Barbados?",
                    new String[] {"280,000", "530,000", "2,400,000"},
                    false, 1),
                new TwoNumQ("What is the calling code of Bosnia and Herzegovina?",
                    new String[] {"281", "387"},
                    false, 2)
        };

        //Canada
        Question[] caQ = new Question[] {
                new TrueFalseQ("Ottawa is both the capital city and largest city of Canada.",
                    false, false)
        };

        //Switzerland
        Question[] chQ = new Question[] {
                new TrueFalseQ("Bern is both the capital city and largest city of Switzerland.",
                    false, false)
        };

        //China
        Question[] cnQ = new Question[] {
                new TrueFalseQ("Beijing is both the capital city and largest city of China.",
                    false, false)
        };

        //Czechia
        Question[] czQ = new Question[] {
                new TrueFalseQ("Prague is both the capital city and largest city of Czechia.",
                    false, true)
        };

        //Denmark
        Question[] dkQ = new Question[] {
                new TrueFalseQ("Copenhagen is both the capital city and largest city of Denmark.",
                    false, true)
        };

        //Greece
        Question[] grQ = new Question[] {
                new TrueFalseQ("Athens is both the capital city and largest city of Greece.",
                    false, false)
        };

        //Japan
        Question[] jpQ = new Question[] {
                new TrueFalseQ("Tokyo is both the capital city and largest city of Japan.",
                    false, false)
        };

        //South Korea
        Question[] krQ = new Question[] {
                new TrueFalseQ("Seoul is both the capital city and largest city of South Korea.",
                    false, true)
        };

        //Qatar
        Question[] qaQ = new Question[] {
                new TrueFalseQ("Doha is both the capital city and largest city of Qatar.",
                    false, true)
        };

        //Vietnam
        Question[] vnQ = new Question[] {
                new TrueFalseQ("Hanoi is both the capital city and largest city of Vietnam.",
                    false, false)
        };

        //Combining country name, flag and questions
        Country[] countriesList = new Country[] {
            new Country("Antigua and Barbuda", R.drawable.flag_ag, Arrays.asList(agQ)),
            new Country("Albania", R.drawable.flag_al, Arrays.asList(alQ)),
            new Country("Australia", R.drawable.flag_au, Arrays.asList(auQ)),
            new Country("Azerbaijan", R.drawable.flag_az, Arrays.asList(azQ)),
            new Country("Bosnia and Herzegovina", R.drawable.flag_ba, Arrays.asList(baQ)),
            new Country("Barbados", R.drawable.flag_bb, Arrays.asList(bbQ)),
            new Country("Canada", R.drawable.flag_ca, Arrays.asList(caQ)),
            new Country("Switzerland", R.drawable.flag_ch, Arrays.asList(chQ)),
            new Country("China", R.drawable.flag_cn, Arrays.asList(cnQ)),
            new Country("Czechia", R.drawable.flag_cz, Arrays.asList(czQ)),
            new Country("Denmark", R.drawable.flag_dk, Arrays.asList(dkQ)),
            new Country("Greece", R.drawable.flag_gr, Arrays.asList(grQ)),
            new Country("Japan", R.drawable.flag_jp, Arrays.asList(jpQ)),
            new Country("South Korea", R.drawable.flag_kr, Arrays.asList(krQ)),
            new Country("Qatar", R.drawable.flag_qa, Arrays.asList(qaQ)),
            new Country("Vietnam", R.drawable.flag_vn, Arrays.asList(vnQ))
        };
        mCountries.addAll(Arrays.asList(countriesList));
    }
}
