package parse.txt.split;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Регулярные выражения - шаблоны написанные на специальном языке
// используемые для проверки строки на соответствие либо поиска совпадений.
// Шаблон регулярного выражения состоит из двух компонентов.

// Правила:

// 1) Любой символ в регулярном выражении представляет сам себя за
// исключением символов со специальным назначением в контексте шаблона.
// "hello" -> "hello" (+); "hello world" (+); "world template" (-);

// 2) `^` - начало строки.
// "^hello" -> "hello world" (+); "world hello" (-);

// 3) `$` - конец строки.
// "hello$" -> "world hello" (+); "hello world" (-);
// "^hello$" -> "hello" (+); "hello world" (-); "hello world hello" (-);

// 4) `.` - любой символ.
// "^a.c$" -> "abc" (+); "azc" (+); "a7c" (+); "a_c" (+); "a_b" (-);

// 5) `\s` - пробел.
// "^a\sc$" -> "a c" (+); "a_c" (-);

// 6) `\d` - цифра от 0 до 9.
// "^a\dc$" -> "a3c" (+); "a7c" (+); "abc" (-); "a#c" (-);

// 7) `\w` - любой латинский символ в любом регистре либо цифра от 0 до 9
// либо символ нижнего подчеркивания.
// "^a\wc$" -> "abc" (+); "aZc" (+); "a7c" (+); "a_c" (+); "a#c" (-);

// 😍 `[]` - группа символов из которой может совпасть любой.
// "[zxv]" - символ z либо x либо v.
// "[a-z]" - любой латинский символ в нижнем регистре.
// "[A-Z]" - любой латинский символ в верхнем регистре.
// "[a-zA-Z]" - любой латинский символ в любом регистре.
// "[а-яё]" - любой кириллический символ в нижнем регистре.
// "[a-zA-Zа-яёА-ЯЁ]" - любой латинский либо кириллический символ в любом
// регистре.
// "[3-7]" - цифра от 3 до 7 включительно.
// "[a-z_3-5.#]" - любой латинский символ в нижнем регистре либо символ
// нижнего подчеркивания либо цифра от 3 до 5 включительно либо точка, либо
// решетка.
// 9) `()` - группировка нескольких правил в одно.

// Количественные модификаторы - специальные конструкции в шаблоне
// регулярного выражения позволяющие определить сколько именно раз должно
// применится то или иное правило. Любое правило по умолчанию применяется
// только 1 раз. Количественный модификатор применяется к тому правилу
// после которого написан.
// `<правило 1><правило 2><количественный модификатор>` - в данном случае
// количественный модификатор применится только к правилу 2, при этом
// правило 1 будет выполнено только один раз.

// Количественные модификаторы:

// 1) `?` - 0 либо 1 раз.
// "^c\d?$" -> "c" (+); "c7" (+); "c777" (-); "c77777" (-); "c7777777" (-);

// 2) `*` - от 0 и более раз.
// "^c\d*$" -> "c" (+); "c7" (+); "c777" (+); "c77777" (+); "c7777777" (+);

// 3) `+` - от 1 и более раз.
// "^c\d+$" -> "c" (-); "c7" (+); "c777" (+); "c77777" (+); "c7777777" (+);

// 4) `{n}` - n раз.
// "^c\d{3}$" -> "c" (-); "c7" (-); "c777" (+); "c77777" (-); "c7777777" (-);

// 5) `{n,}` - от n и более раз.
// "^c\d{3,}$" -> "c" (-); "c7" (-); "c777" (+); "c77777" (+); "c7777777" (+);

// 6) `{n1,n2}` - от n1 до n2 раз включительно.
// "^c\d{3,5}$" -> "c" (-); "c7" (-); "c777" (+); "c77777" (+); "c7777777" (-);

// Экранирование символов со специальным назначением - процесс при котором
// символ со специальным назначением становится обычным символом.

// `.` (любой символ);
// `\.` (точка);
// `+` (количественный модификатор);
// `\+` (плюс);

// `*.matches(String regex) : boolean` - возвращает true если исходная
// строка соответствует шаблону регулярного выражения regex.

public class ObjectListFromFile {
    private final String fileWithData = "C:\\Users\\Amirzhan\\Documents\\forPracticant\\text_for_parse.txt";
    private final String updatedFileWithData = "C:\\Users\\Amirzhan\\Documents\\forPracticant\\updated_text_for_parse.txt";
    public String[] splitFile() throws IOException {

        FileReader input = new FileReader(fileWithData);
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(input)){
            String line = null;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }
        }
        System.out.println(stringBuilder);
//        String[] strs = stringBuilder.toString().split(",");
//        int counter = 0;
//        int countOfStrs = 0;
//        int numberOfStrs = strs.length / 8;
//        String[] words = new String[numberOfStrs];
//        String newStr = null;
//        for (String str : strs) {
//            counter++;
//            if (newStr == null){
//                newStr = str;
//            } else {
//                newStr = newStr + str;
//            }
//            if (counter == 8){
//                words[countOfStrs] = newStr;
//                countOfStrs++;
//                newStr = null;
//                counter = 0;
//            }
//        }

        String str = stringBuilder.toString();
        int strLength = str.length();
        String newStr = str.substring(10, strLength);
        //str = str.substring(2, strLength - 1);
        System.out.println(newStr);
        return null;
    }
}
