/**
 * Frank Berrocal Azofeifa
 * Final Project
 *
 * SODV3203 Mobile Application Development
 * Prof.  Ali Moussa
 * Bow Valley College
 *
 * April 2023
 */

package com.example.finalproject_fberrocal;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Tree {
    final BinarySearchTree tree = new BinarySearchTree ();
    private Node country = new Node();

    private Map<Integer, Node> dataSelectedNodes = new HashMap<>();
    private String CountryName;
    private String CountryFile;
    private Boolean CountryAnswer;


    /**
     * constructCountryTree()
     *
     * @param
     * @return
     * Filling of data into a tree structure, to get search efficiency and speed.
     * RC O(log n)
     */
    public void constructCountryTree(){
        tree.insert("Afghanistan","af",1,false);
        tree.insert("Albania","al",2,false);
        tree.insert("Algeria","dz",3,false);
        tree.insert("American Samoa","as",4,false);
        tree.insert("Andorra","ad",5,false);
        tree.insert("Angola","ao",6,false);
        tree.insert("Anguilla","ai",7,false);
        tree.insert("Antarctica","aq",8,false);
        tree.insert("Antigua and Barbuda","ag",9,false);
        tree.insert("Argentina","ar",10,false);
        tree.insert("Armenia","am",11,false);
        tree.insert("Aruba","aw",12,false);
        tree.insert("Australia","au",13,false);
        tree.insert("Austria","at",14,false);
        tree.insert("Azerbaijan","az",15,false);
        tree.insert("Bahamas","bs",16,false);
        tree.insert("Bahrain","bh",17,false);
        tree.insert("Bangladesh","bd",18,false);
        tree.insert("Barbados","bb",19,false);
        tree.insert("Belarus","by",20,false);
        tree.insert("Belgium","be",21,false);
        tree.insert("Belize","bz",22,false);
        tree.insert("Benin","bj",23,false);
        tree.insert("Bermuda","bm",24,false);
        tree.insert("Bhutan","bt",25,false);
        tree.insert("Bolivia","bo",26,false);
        tree.insert("Bosnia and Herzegovina","ba",27,false);
        tree.insert("Botswana","bw",28,false);
        tree.insert("Bouvet Island","bv",29,false);
        tree.insert("Brazil","br",30,false);
        tree.insert("British Indian Ocean Territory","io",31,false);
        tree.insert("Brunei","bn",32,false);
        tree.insert("Bulgaria","bg",33,false);
        tree.insert("Burkina Faso","bf",34,false);
        tree.insert("Burundi","bi",35,false);
        tree.insert("Cambodia","kh",36,false);
        tree.insert("Cameroon","cm",37,false);
        tree.insert("Canada","ca",38,false);
        tree.insert("Cape Verde","cv",39,false);
        tree.insert("Cayman Islands","ky",40,false);
        tree.insert("Central African Republic","cf",41,false);
        tree.insert("Chad","td",42,false);
        tree.insert("Chile","cl",43,false);
        tree.insert("China","cn",44,false);
        tree.insert("Christmas Island","cx",45,false);
        tree.insert("Cocos (Keeling) Islands","cc",46,false);
        tree.insert("Colombia","co",47,false);
        tree.insert("Comoros","km",48,false);
        tree.insert("Congo","cg",49,false);
        tree.insert("Cook Islands","ck",50,false);
        tree.insert("Costa Rica","cr",51,false);
        tree.insert("Croatia","hr",52,false);
        tree.insert("Cuba","cu",53,false);
        tree.insert("Cyprus","cy",54,false);
        tree.insert("Czech Republic","cz",55,false);
        tree.insert("Democratic Republic of the Congo","cd",56,false);
        tree.insert("Denmark","dk",57,false);
        tree.insert("Djibouti","dj",58,false);
        tree.insert("Dominica","dm",59,false);
        tree.insert("Dominican Republic","dr",60,false);
        tree.insert("Ecuador","ec",61,false);
        tree.insert("Egypt","eg",62,false);
        tree.insert("El Salvador","sv",63,false);
        tree.insert("Equatorial Guinea","gq",64,false);
        tree.insert("Eritrea","er",65,false);
        tree.insert("Estonia","ee",66,false);
        tree.insert("Ethiopia","et",67,false);
        tree.insert("Falkland Islands (Malvinas)","fk",68,false);
        tree.insert("Faroe Islands","fo",69,false);
        tree.insert("Fiji","fj",70,false);
        tree.insert("Finland","fi",71,false);
        tree.insert("France","fr",72,false);
        tree.insert("French Guiana","gf",73,false);
        tree.insert("French Polynesia","pf",74,false);
        tree.insert("French Southern Territories","tf",75,false);
        tree.insert("Gabon","ga",76,false);
        tree.insert("Gambia","gm",77,false);
        tree.insert("Georgia","ge",78,false);
        tree.insert("Germany","de",79,false);
        tree.insert("Ghana","gh",80,false);
        tree.insert("Gibraltar","gi",81,false);
        tree.insert("Greece","gr",82,false);
        tree.insert("Greenland","gl",83,false);
        tree.insert("Grenada","gd",84,false);
        tree.insert("Guadeloupe","gp",85,false);
        tree.insert("Guam","gu",86,false);
        tree.insert("Guatemala","gt",87,false);
        tree.insert("Guinea","gn",88,false);
        tree.insert("Guinea Bissau","gw",89,false);
        tree.insert("Guyana","gy",90,false);
        tree.insert("Haiti","ht",91,false);
        tree.insert("Heard Island and McDonald Islands","hm",92,false);
        tree.insert("Holy See (Vatican)","va",93,false);
        tree.insert("Honduras","hn",94,false);
        tree.insert("Hungary","hu",95,false);
        tree.insert("Iceland","is",96,false);
        tree.insert("India","in",97,false);
        tree.insert("Indonesia","id",98,false);
        tree.insert("Iran","ir",99,false);
        tree.insert("Iraq","iq",100,false);
        tree.insert("Ireland","ie",101,false);
        tree.insert("Israel","il",102,false);
        tree.insert("Italy","it",103,false);
        tree.insert("Jamaica","jm",104,false);
        tree.insert("Japan","jp",105,false);
        tree.insert("Jordan","jo",106,false);
        tree.insert("Kazakhstan","kz",107,false);
        tree.insert("Kenya","ke",108,false);
        tree.insert("Kiribati","ki",109,false);
        tree.insert("Kuwait","kw",110,false);
        tree.insert("Kyrgyzstan","kg",111,false);
        tree.insert("Laos","la",112,false);
        tree.insert("Latvia","lv",113,false);
        tree.insert("Lebanon","lb",114,false);
        tree.insert("Lesotho","ls",115,false);
        tree.insert("Liberia","lr",116,false);
        tree.insert("Libya","ly",117,false);
        tree.insert("Liechtenstein","li",118,false);
        tree.insert("Lithuania","lt",119,false);
        tree.insert("Luxembourg","lu",120,false);
        tree.insert("Madagascar","mg",121,false);
        tree.insert("Malawi","mw",122,false);
        tree.insert("Malaysia","my",123,false);
        tree.insert("Maldives","mv",124,false);
        tree.insert("Mali","ml",125,false);
        tree.insert("Malta","mt",126,false);
        tree.insert("Marshall Islands","mh",127,false);
        tree.insert("Mauritania","mr",128,false);
        tree.insert("Mauritius","mu",129,false);
        tree.insert("Mexico","mx",130,false);
        tree.insert("Micronesia","fm",131,false);
        tree.insert("Moldova","md",132,false);
        tree.insert("Monaco","mc",133,false);
        tree.insert("Mongolia","mn",134,false);
        tree.insert("Montenegro","me",135,false);
        tree.insert("Morocco","ma",136,false);
        tree.insert("Mozambique","mz",137,false);
        tree.insert("Myanmar (Burma)","mm",138,false);
        tree.insert("Namibia","na",139,false);
        tree.insert("Nauru","nr",140,false);
        tree.insert("Nepal","np",141,false);
        tree.insert("Netherlands","nl",142,false);
        tree.insert("New Zealand","nz",143,false);
        tree.insert("Nicaragua","ni",144,false);
        tree.insert("Niger","ne",145,false);
        tree.insert("Nigeria","ng",146,false);
        tree.insert("North Korea","kp",147,false);
        tree.insert("North Macedonia","mk",148,false);
        tree.insert("Norway","no",149,false);
        tree.insert("Oman","om",150,false);
        tree.insert("Pakistan","pk",151,false);
        tree.insert("Palau","pw",152,false);
        tree.insert("Palestine","ps",153,false);
        tree.insert("Panama","pa",154,false);
        tree.insert("Papua New Guinea","pg",155,false);
        tree.insert("Paraguay","py",156,false);
        tree.insert("Peru","pe",157,false);
        tree.insert("Philippines","ph",158,false);
        tree.insert("Poland","pl",159,false);
        tree.insert("Portugal","pt",160,false);
        tree.insert("Qatar","qa",161,false);
        tree.insert("Romania","ro",162,false);
        tree.insert("Russia","ru",163,false);
        tree.insert("Rwanda","rw",164,false);
        tree.insert("Saint Kitts and Nevis","kn",165,false);
        tree.insert("Saint Lucia","lc",166,false);
        tree.insert("Saint Vincent and the Grenadines","vc",167,false);
        tree.insert("Samoa","ws",168,false);
        tree.insert("San Marino","sm",169,false);
        tree.insert("Sao Tome and Principe","st",170,false);
        tree.insert("Saudi Arabia","sa",171,false);
        tree.insert("Senegal","sn",172,false);
        tree.insert("Serbia","rs",173,false);
        tree.insert("Seychelles","sc",174,false);
        tree.insert("Sierra Leone","sl",175,false);
        tree.insert("Singapore","sg",176,false);
        tree.insert("Slovakia","sk",177,false);
        tree.insert("Slovenia","si",178,false);
        tree.insert("Solomon Islands","sb",179,false);
        tree.insert("Somalia","so",180,false);
        tree.insert("South Africa","za",181,false);
        tree.insert("South Korea","kr",182,false);
        tree.insert("South Sudan","ss",183,false);
        tree.insert("Spain","es",184,false);
        tree.insert("Sri Lanka","lk",185,false);
        tree.insert("Sudan","sd",186,false);
        tree.insert("Suriname","sr",187,false);
        tree.insert("Sweden","se",188,false);
        tree.insert("Switzerland","ch",189,false);
        tree.insert("Syria","sy",190,false);
        tree.insert("Taiwan","tw",191,false);
        tree.insert("Tajikistan","tj",192,false);
        tree.insert("Tanzania","tz",193,false);
        tree.insert("Thailand","th",194,false);
        tree.insert("Timor Leste (East Timor)","tl",195,false);
        tree.insert("Togo","tg",196,false);
        tree.insert("Tonga","to",197,false);
        tree.insert("Trinidad and Tobago","tt",198,false);
        tree.insert("Tunisia","tn",199,false);
        tree.insert("Turkey","tr",200,false);
        tree.insert("Turkmenistan","tm",201,false);
        tree.insert("Tuvalu","tv",202,false);
        tree.insert("Uganda","ug",203,false);
        tree.insert("Ukraine","ua",204,false);
        tree.insert("United Arab Emirates","ae",205,false);
        tree.insert("United Kingdom","gb",206,false);
        tree.insert("United States","us",207,false);
        tree.insert("Uruguay","uy",208,false);
        tree.insert("Uzbekistan","uz",209,false);
        tree.insert("Vanuatu","vu",210,false);
        tree.insert("Venezuela","ve",211,false);
        tree.insert("Vietnam","vn",212,false);
        tree.insert("Yemen","ye",213,false);
        tree.insert("Zambia","zm",214,false);
        tree.insert("Zimbabwe","zw",215,false);
        tree.insert("Côte d'Ivoire","ci",216,false);
        tree.insert("Eswatini (Swaziland)","sz",217,false);
        tree.insert("Falkland Islands","fk",218,false);
        tree.insert("Guernsey","gg",219,false);
        tree.insert("Guinea-Bissau","gw",220,false);
        tree.insert("Heard and McDonald Islands","hm",221,false);
        tree.insert("Vatican City State","va",222,false);
        tree.insert("Hong Kong","hk",223,false);
        tree.insert("Isle of Man","im",224,false);
        tree.insert("Jersey","je",225,false);
        tree.insert("Lao People's Democratic Republic","la",226,false);
        tree.insert("Macao","mo",227,false);
        tree.insert("Martinique","mp",228,false);
        tree.insert("Mayotte","yt",229,false);
        tree.insert("Montserrat","ms",230,false);
        tree.insert("Myanmar","mm",231,false);
        tree.insert("New Caledonia","nc",232,false);
        tree.insert("Niue","nu",233,false);
        tree.insert("Norfolk Island","nf",234,false);
        tree.insert("Northern Mariana Islands","mp",235,false);
        tree.insert("Pitcairn Islands","pn",236,false);
        tree.insert("Puerto Rico","pr",237,false);
        tree.insert("Réunion","re",238,false);
        tree.insert("Saint Barthélemy","bl",239,false);
        tree.insert("Saint Helena","sh",240,false);
        tree.insert("Saint Martin","mf",241,false);
        tree.insert("Saint Pierre and Miquelon","pm",242,false);
        tree.insert("Sint Maarten (Dutch part)","sx",243,false);
        tree.insert("South Georgia and the South Sandwich Islands","gs",244,false);
        tree.insert("Svalbard and Jan Mayen Islands","sj",245,false);
        tree.insert("Timor-Leste","tl",246,false);
        tree.insert("Tokelau","tk",247,false);
        tree.insert("Turks and Caicos Islands","tc",248,false);
        tree.insert("Virgin Islands, British","vg",249,false);
        tree.insert("Virgin Islands, U.S.","vi",250,false);
        tree.insert("Wallis and Futuna","wf",251,false);
        tree.insert("Western Sahara","eh",252,false);
    }

    /**
     * Tree()
     *
     * @param
     * @return
     * Class default constructor.  Creates a world tree each time an instance is initialized.
     * RC O(log n)
     */
    public Tree(){
        constructCountryTree();
    }


    /**
     * getCountryInfo
     *
     * @param index
     * @return Node
     * Use the index, call the methods getCountryName and getCountryFile,
     * and return the information in a Node.
     * RC O(log n)
     */
    public Node getCountryInfo(int index){
        country = tree.search(index);
        return country;
    }

    /**
     * getCountryName()
     *
     * @param index
     * @return String
     * Use the index to search in the binary tree, retrieve the CountryName saved in the node with id == index.
     * RC O(log n)
     */
    private String getCountryName(int index){
        CountryName = tree.search(index).getCountryName();
        return CountryName;
    }

    /**
     * getCountryName()
     *
     * @param index
     * @return String
     * Use the index to search in the binary tree, retrieve the CountryFile saved in the node with id == index.
     * RC O(log n)
     */

    private String getCountryFile(int index){
        CountryFile = tree.search(index).getCountryFile();
        return CountryFile;
    }

    /**
     * getCountryAnswer()
     *
     * @param index
     * @return boolean
     * Use the index to search in the binary tree, retrieve the CountryAnswer saved in the node with id == index.
     * RC O(log n)
     */
    private Boolean getCountryAnswer(int index){
        CountryAnswer = tree.search(index).getCountryAnswer();
        return CountryAnswer;
    }


    /**
     * getCountryAnswer()
     *
     * @param
     * @return
     * Use binarySearch to retrieve the total amount of elements in the tree
     * RC O(log n)
     */
    public int totalCountries(){
        return tree.totalCountries();
    }



}
