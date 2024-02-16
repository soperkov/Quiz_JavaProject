import java.util.*;

public class Questions {

    private String[][] questions;

    public Questions() {
        this.questions = new String[][]{
                {"Koji je glavni grad Austrije?", "Beč", "London", "Berlin", "Madrid"},
                {"Kada je završio drugi Svjetski rat?", "1945.", "1946.", "1944.", "1939."},
                {"Kako se zove poznati film baziran na knjizi Stephena Kinga u kojem je glumio Jack Nicholson?", "Isijavanje", "Vještice iz Salema", "Egzorcist", "1922"},
                {"Kako se zove grčka božica lova?", "Artemida", "Hera", "Afrodita", "Atena"},
                {"Koji kemijski element na latinskom predstavlja sunce?", "Helij", "Dušik", "Ugljik", "Platina"},
                {"Kako se zove poznata pjevačica koja glumi u filmu sa Bradley Cooper-om?", "Lady Gaga", "Beyonce", "Rihanna", "Shakira"},
                {"Koliko čovječuljaka ima svaki igrač na početku igre imena Čovječe ne ljuti se?", "4", "3", "5", "6"},
                {"Koja je službena valuta u Hrvatskoj?", "Euro", "Kuna", "Funta", "Dolar"},
                {"Kako se zove najpoznatiji portugalski nogometaš koji je igrao u Real Madridu?", "Cristiano Ronaldo", "Lionel Messi", "Neymar", "Paul Pogba"},
                {"Koja od slijedećih glumica nosi jednu od glavnih uloga u Marvelovom filmu 'Avengers'?", "Scarlet Johansson", "Jessica Alba", "Kate Hudson", "Anna Faris"},
                {"Koja biljka se nalazi na zastavi Kanade?", "Javor", "Peršin", "Jasen", "Ruža"},
                {"Kako se nazivaju ćelije zaslužne za razvoj kostiju?", "Osteoblasti", "Lizosomi", "Citoplazme", "Trombociti"},
                {"Mn je simbol kojeg kemijskog elementa?", "Mangana", "Magnezija", "Mendelevija", "Mitohondrija"},
                {"Koje je boje klorofil?", "Zelene", "Žute", "Crvene", "Plave"},
                {"Koji je glavni grad Japana?", "Tokio", "Kyoto", "Osaka", "Sapporo"},
                {"Gdje se nalazi Eiffelov toranj?", "Pariz", "London", "Berlin", "New York"},
                {"Koje godine je počeo Prvi svjetski rat?", "1914.", "1915.", "1916.", "1917."},
                {"Tko je napisao knjigu 'Rat i mir'?", "Lev Tolstoj", "Fjodor Dostojevski", "Ivan Turgenjev", "Anton Pavlovič Čehov"},
                {"Koji je najduži rijeka u svijetu?", "Nile", "Amazona", "Mississippi", "Yangtze"},
                {"Koja je najveća planina na Zemlji?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse"},
                {"Tko je autor knjige 'Harry Potter'?", "J.K. Rowling", "Stephen King", "J.R.R. Tolkien", "C.S. Lewis"},
                {"Koji je glavni grad Rusije?", "Moskva", "Sankt Peterburg", "Kazanj", "Novosibirsk"},
                {"Tko je napisao knjigu 'Vojna i mir'?", "Lev Tolstoj", "Fjodor Dostojevski", "Ivan Turgenjev", "Anton Pavlovič Čehov"},
                {"Koje godine je rođen Albert Einstein?", "1879.", "1881.", "1877.", "1883."},
                {"Tko je prvi čovjek koji je hodao po Mjesecu?", "Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Alan Shepard"},
                {"Koji je najveći ocean na Zemlji?", "Tihii", "Atlantski", "Indijski", "Arktički"},
                {"Koje godine je završio Prvi svjetski rat?", "1918.", "1919.", "1920.", "1921."},
                {"Tko je autor knjige 'Ana Karenjina'?", "Lev Tolstoj", "Fjodor Dostojevski", "Ivan Turgenjev", "Anton Pavlovič Čehov"},
                {"Koja je najveća životinja na Zemlji?", "Plavi kit", "Slon", "Gorila", "Krokodil"},
                {"Koliko planeta ima u Sunčevom sustavu?", "8", "7", "9", "10"},
                {"Koji je glavni grad Kine?", "Peking", "Šangaj", "Hong Kong", "Guangzhou"},
                {"Koji je najviši vrh u Europi?", "Elbrus", "Mont Blanc", "Matterhorn", "Monch"},
                {"Tko je napisao knjigu 'Romeo i Julija'?", "William Shakespeare", "Jane Austen", "Charles Dickens", "Emily Bronte"},
                {"Koji je najduži rijeka u Europi?", "Volga", "Dunav", "Don", "Dnjepar"},
                {"Koje godine je počeo Američki građanski rat?", "1861.", "1860.", "1862.", "1863."},
                {"Tko je napisao knjigu 'Ljudi su iz Marsove kugle'?", "Antun Gustav Matoš", "Miroslav Krleža", "August Šenoa", "Ivan Gundulić"},
                {"Koja je najveća država na svijetu?", "Rusija", "Kanada", "Kina", "SAD"},
                {"Koje je glavno sredstvo prijenosa topline u Zemljinoj atmosferi?", "Zrak", "Voda", "Zemlja", "Vatra"},
                {"Koji je glavni grad Australije?", "Canberra", "Sydney", "Melbourne", "Brisbane"},
                {"Tko je napisao knjigu 'Gospodar prstenova'?", "J.R.R. Tolkien", "C.S. Lewis", "J.K. Rowling", "Stephen King"},
                {"Koje godine je potopljen Titanik?", "1912.", "1913.", "1914.", "1915."},
                {"Tko je prvi otkrio Ameriku?", "Kristofor Kolumbo", "Amerigo Vespucci", "Vasco da Gama", "Ferdinand Magellan"},
                {"Koji je najveći kontinent na Zemlji?", "Azija", "Afrika", "Sjeverna Amerika", "Južna Amerika"},
                {"Koja je najčešća krvna grupa kod ljudi?", "A", "B", "AB", "0"},
                {"Koji je glavni grad Španjolske?", "Madrid", "Barcelona", "Valencia", "Sevilla"},
                {"Tko je napisao knjigu '1984'?", "George Orwell", "Aldous Huxley", "Ray Bradbury", "Isaac Asimov"}
        };

    }

    public List<String[]> getRandomQuestions(int numQuestions) {
        if (numQuestions >= questions.length) {
            return Arrays.asList(questions);
        } else {
            List<String[]> shuffledQuestions = Arrays.asList(questions);
            Collections.shuffle(shuffledQuestions);
            return shuffledQuestions.subList(0, numQuestions);
        }
    }

    public Questions(List<String[]> questionsList) {
        questions = questionsList.toArray(new String[0][]);
    }

    public int getQuestionsLength() {
        return questions.length;
    }

    public Iterator<String[]> iterator() {
        return new QuestionsIterator();
    }

    private class QuestionsIterator implements Iterator<String[]> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < questions.length;
        }

        @Override
        public String[] next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements in the iterator.");
            }
            return questions[currentIndex++];
        }
    }

    public String[] getQuestionAtIndex(int index) {
        return questions[index];
    }

    public String[][] getQuestions() {
        return questions;
    }

}

