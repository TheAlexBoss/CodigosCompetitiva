package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Uvas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        //generaArray();

        int[] array = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, 276, 300, 325, 351, 378, 406, 435, 465, 496, 528, 561, 595, 630, 666, 703, 741, 780, 820, 861, 903, 946, 990, 1035, 1081, 1128, 1176, 1225, 1275, 1326, 1378, 1431, 1485, 1540, 1596, 1653, 1711, 1770, 1830, 1891, 1953, 2016, 2080, 2145, 2211, 2278, 2346, 2415, 2485, 2556, 2628, 2701, 2775, 2850, 2926, 3003, 3081, 3160, 3240, 3321, 3403, 3486, 3570, 3655, 3741, 3828, 3916, 4005, 4095, 4186, 4278, 4371, 4465, 4560, 4656, 4753, 4851, 4950, 5050, 5151, 5253, 5356, 5460, 5565, 5671, 5778, 5886, 5995, 6105, 6216, 6328, 6441, 6555, 6670, 6786, 6903, 7021, 7140, 7260, 7381, 7503, 7626, 7750, 7875, 8001, 8128, 8256, 8385, 8515, 8646, 8778, 8911, 9045, 9180, 9316, 9453, 9591, 9730, 9870, 10011, 10153, 10296, 10440, 10585, 10731, 10878, 11026, 11175, 11325, 11476, 11628, 11781, 11935, 12090, 12246, 12403, 12561, 12720, 12880, 13041, 13203, 13366, 13530, 13695, 13861, 14028, 14196, 14365, 14535, 14706, 14878, 15051, 15225, 15400, 15576, 15753, 15931, 16110, 16290, 16471, 16653, 16836, 17020, 17205, 17391, 17578, 17766, 17955, 18145, 18336, 18528, 18721, 18915, 19110, 19306, 19503, 19701, 19900, 20100, 20301, 20503, 20706, 20910, 21115, 21321, 21528, 21736, 21945, 22155, 22366, 22578, 22791, 23005, 23220, 23436, 23653, 23871, 24090, 24310, 24531, 24753, 24976, 25200, 25425, 25651, 25878, 26106, 26335, 26565, 26796, 27028, 27261, 27495, 27730, 27966, 28203, 28441, 28680, 28920, 29161, 29403, 29646, 29890, 30135, 30381, 30628, 30876, 31125, 31375, 31626, 31878, 32131, 32385, 32640, 32896, 33153, 33411, 33670, 33930, 34191, 34453, 34716, 34980, 35245, 35511, 35778, 36046, 36315, 36585, 36856, 37128, 37401, 37675, 37950, 38226, 38503, 38781, 39060, 39340, 39621, 39903, 40186, 40470, 40755, 41041, 41328, 41616, 41905, 42195, 42486, 42778, 43071, 43365, 43660, 43956, 44253, 44551, 44850, 45150, 45451, 45753, 46056, 46360, 46665, 46971, 47278, 47586, 47895, 48205, 48516, 48828, 49141, 49455, 49770, 50086, 50403, 50721, 51040, 51360, 51681, 52003, 52326, 52650, 52975, 53301, 53628, 53956, 54285, 54615, 54946, 55278, 55611, 55945, 56280, 56616, 56953, 57291, 57630, 57970, 58311, 58653, 58996, 59340, 59685, 60031, 60378, 60726, 61075, 61425, 61776, 62128, 62481, 62835, 63190, 63546, 63903, 64261, 64620, 64980, 65341, 65703, 66066, 66430, 66795, 67161, 67528, 67896, 68265, 68635, 69006, 69378, 69751, 70125, 70500, 70876, 71253, 71631, 72010, 72390, 72771, 73153, 73536, 73920, 74305, 74691, 75078, 75466, 75855, 76245, 76636, 77028, 77421, 77815, 78210, 78606, 79003, 79401, 79800, 80200, 80601, 81003, 81406, 81810, 82215, 82621, 83028, 83436, 83845, 84255, 84666, 85078, 85491, 85905, 86320, 86736, 87153, 87571, 87990, 88410, 88831, 89253, 89676, 90100, 90525, 90951, 91378, 91806, 92235, 92665, 93096, 93528, 93961, 94395, 94830, 95266, 95703, 96141, 96580, 97020, 97461, 97903, 98346, 98790, 99235, 99681, 100128, 100576, 101025, 101475, 101926, 102378, 102831, 103285, 103740, 104196, 104653, 105111, 105570, 106030, 106491, 106953, 107416, 107880, 108345, 108811, 109278, 109746, 110215, 110685, 111156, 111628, 112101, 112575, 113050, 113526, 114003, 114481, 114960, 115440, 115921, 116403, 116886, 117370, 117855, 118341, 118828, 119316, 119805, 120295, 120786, 121278, 121771, 122265, 122760, 123256, 123753, 124251, 124750, 125250, 125751, 126253, 126756, 127260, 127765, 128271, 128778, 129286, 129795, 130305, 130816, 131328, 131841, 132355, 132870, 133386, 133903, 134421, 134940, 135460, 135981, 136503, 137026, 137550, 138075, 138601, 139128, 139656, 140185, 140715, 141246, 141778, 142311, 142845, 143380, 143916, 144453, 144991, 145530, 146070, 146611, 147153, 147696, 148240, 148785, 149331, 149878, 150426, 150975, 151525, 152076, 152628, 153181, 153735, 154290, 154846, 155403, 155961, 156520, 157080, 157641, 158203, 158766, 159330, 159895, 160461, 161028, 161596, 162165, 162735, 163306, 163878, 164451, 165025, 165600, 166176, 166753, 167331, 167910, 168490, 169071, 169653, 170236, 170820, 171405, 171991, 172578, 173166, 173755, 174345, 174936, 175528, 176121, 176715, 177310, 177906, 178503, 179101, 179700, 180300, 180901, 181503, 182106, 182710, 183315, 183921, 184528, 185136, 185745, 186355, 186966, 187578, 188191, 188805, 189420, 190036, 190653, 191271, 191890, 192510, 193131, 193753, 194376, 195000, 195625, 196251, 196878, 197506, 198135, 198765, 199396, 200028, 200661, 201295, 201930, 202566, 203203, 203841, 204480, 205120, 205761, 206403, 207046, 207690, 208335, 208981, 209628, 210276, 210925, 211575, 212226, 212878, 213531, 214185, 214840, 215496, 216153, 216811, 217470, 218130, 218791, 219453, 220116, 220780, 221445, 222111, 222778, 223446, 224115, 224785, 225456, 226128, 226801, 227475, 228150, 228826, 229503, 230181, 230860, 231540, 232221, 232903, 233586, 234270, 234955, 235641, 236328, 237016, 237705, 238395, 239086, 239778, 240471, 241165, 241860, 242556, 243253, 243951, 244650, 245350, 246051, 246753, 247456, 248160, 248865, 249571, 250278, 250986, 251695, 252405, 253116, 253828, 254541, 255255, 255970, 256686, 257403, 258121, 258840, 259560, 260281, 261003, 261726, 262450, 263175, 263901, 264628, 265356, 266085, 266815, 267546, 268278, 269011, 269745, 270480, 271216, 271953, 272691, 273430, 274170, 274911, 275653, 276396, 277140, 277885, 278631, 279378, 280126, 280875, 281625, 282376, 283128, 283881, 284635, 285390, 286146, 286903, 287661, 288420, 289180, 289941, 290703, 291466, 292230, 292995, 293761, 294528, 295296, 296065, 296835, 297606, 298378, 299151, 299925, 300700, 301476, 302253, 303031, 303810, 304590, 305371, 306153, 306936, 307720, 308505, 309291, 310078, 310866, 311655, 312445, 313236, 314028, 314821, 315615, 316410, 317206, 318003, 318801, 319600, 320400, 321201, 322003, 322806, 323610, 324415, 325221, 326028, 326836, 327645, 328455, 329266, 330078, 330891, 331705, 332520, 333336, 334153, 334971, 335790, 336610, 337431, 338253, 339076, 339900, 340725, 341551, 342378, 343206, 344035, 344865, 345696, 346528, 347361, 348195, 349030, 349866, 350703, 351541, 352380, 353220, 354061, 354903, 355746, 356590, 357435, 358281, 359128, 359976, 360825, 361675, 362526, 363378, 364231, 365085, 365940, 366796, 367653, 368511, 369370, 370230, 371091, 371953, 372816, 373680, 374545, 375411, 376278, 377146, 378015, 378885, 379756, 380628, 381501, 382375, 383250, 384126, 385003, 385881, 386760, 387640, 388521, 389403, 390286, 391170, 392055, 392941, 393828, 394716, 395605, 396495, 397386, 398278, 399171, 400065, 400960, 401856, 402753, 403651, 404550, 405450, 406351, 407253, 408156, 409060, 409965, 410871, 411778, 412686, 413595, 414505, 415416, 416328, 417241, 418155, 419070, 419986, 420903, 421821, 422740, 423660, 424581, 425503, 426426, 427350, 428275, 429201, 430128, 431056, 431985, 432915, 433846, 434778, 435711, 436645, 437580, 438516, 439453, 440391, 441330, 442270, 443211, 444153, 445096, 446040, 446985, 447931, 448878, 449826, 450775, 451725, 452676, 453628, 454581, 455535, 456490, 457446, 458403, 459361, 460320, 461280, 462241, 463203, 464166, 465130, 466095, 467061, 468028, 468996, 469965, 470935, 471906, 472878, 473851, 474825, 475800, 476776, 477753, 478731, 479710, 480690, 481671, 482653, 483636, 484620, 485605, 486591, 487578, 488566, 489555, 490545, 491536, 492528, 493521, 494515, 495510, 496506, 497503, 498501, 499500, 500500, 501501, 502503, 503506, 504510, 505515, 506521, 507528, 508536, 509545, 510555, 511566, 512578, 513591, 514605, 515620, 516636, 517653, 518671, 519690, 520710, 521731, 522753, 523776, 524800, 525825, 526851, 527878, 528906, 529935, 530965, 531996, 533028, 534061, 535095, 536130, 537166, 538203, 539241, 540280, 541320, 542361, 543403, 544446, 545490, 546535, 547581, 548628, 549676, 550725, 551775, 552826, 553878, 554931, 555985, 557040, 558096, 559153, 560211, 561270, 562330, 563391, 564453, 565516, 566580, 567645, 568711, 569778, 570846, 571915, 572985, 574056, 575128, 576201, 577275, 578350, 579426, 580503, 581581, 582660, 583740, 584821, 585903, 586986, 588070, 589155, 590241, 591328, 592416, 593505, 594595, 595686, 596778, 597871, 598965, 600060, 601156, 602253, 603351, 604450, 605550, 606651, 607753, 608856, 609960, 611065, 612171, 613278, 614386, 615495, 616605, 617716, 618828, 619941, 621055, 622170, 623286, 624403, 625521, 626640, 627760, 628881, 630003, 631126, 632250, 633375, 634501, 635628, 636756, 637885, 639015, 640146, 641278, 642411, 643545, 644680, 645816, 646953, 648091, 649230, 650370, 651511, 652653, 653796, 654940, 656085, 657231, 658378, 659526, 660675, 661825, 662976, 664128, 665281, 666435, 667590, 668746, 669903, 671061, 672220, 673380, 674541, 675703, 676866, 678030, 679195, 680361, 681528, 682696, 683865, 685035, 686206, 687378, 688551, 689725, 690900, 692076, 693253, 694431, 695610, 696790, 697971, 699153, 700336, 701520, 702705, 703891, 705078, 706266, 707455, 708645, 709836, 711028, 712221, 713415, 714610, 715806, 717003, 718201, 719400, 720600, 721801, 723003, 724206, 725410, 726615, 727821, 729028, 730236, 731445, 732655, 733866, 735078, 736291, 737505, 738720, 739936, 741153, 742371, 743590, 744810, 746031, 747253, 748476, 749700, 750925, 752151, 753378, 754606, 755835, 757065, 758296, 759528, 760761, 761995, 763230, 764466, 765703, 766941, 768180, 769420, 770661, 771903, 773146, 774390, 775635, 776881, 778128, 779376, 780625, 781875, 783126, 784378, 785631, 786885, 788140, 789396, 790653, 791911, 793170, 794430, 795691, 796953, 798216, 799480, 800745, 802011, 803278, 804546, 805815, 807085, 808356, 809628, 810901, 812175, 813450, 814726, 816003, 817281, 818560, 819840, 821121, 822403, 823686, 824970, 826255, 827541, 828828, 830116, 831405, 832695, 833986, 835278, 836571, 837865, 839160, 840456, 841753, 843051, 844350, 845650, 846951, 848253, 849556, 850860, 852165, 853471, 854778, 856086, 857395, 858705, 860016, 861328, 862641, 863955, 865270, 866586, 867903, 869221, 870540, 871860, 873181, 874503, 875826, 877150, 878475, 879801, 881128, 882456, 883785, 885115, 886446, 887778, 889111, 890445, 891780, 893116, 894453, 895791, 897130, 898470, 899811, 901153, 902496, 903840, 905185, 906531, 907878, 909226, 910575, 911925, 913276, 914628, 915981, 917335, 918690, 920046, 921403, 922761, 924120, 925480, 926841, 928203, 929566, 930930, 932295, 933661, 935028, 936396, 937765, 939135, 940506, 941878, 943251, 944625, 946000, 947376, 948753, 950131, 951510, 952890, 954271, 955653, 957036, 958420, 959805, 961191, 962578, 963966, 965355, 966745, 968136, 969528, 970921, 972315, 973710, 975106, 976503, 977901, 979300, 980700, 982101, 983503, 984906, 986310, 987715, 989121, 990528, 991936, 993345, 994755, 996166, 997578, 998991, 1000405};

        int N;
        while((N = scn.nextInt()) != 0){
            pw.println(binarySearch(N,array,0,array.length-1));
        }
        pw.flush();

    }


    public static int binarySearch(int search, int[] array, int min, int max){
        int mid = (min+max)/2;

        if(array[mid] == search)
            return mid;

        if(mid == min && mid == max)
            return mid;

        if(array[mid] < search)
            return binarySearch(search, array, mid+1,max);
        else
            return binarySearch(search,array,min,mid);
    }

    public static void generaArray(){
        //Pequeño dp para precalcular todos los valores

        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        int i = 1, cuenta;

        while(array.get(i-1) < 1000000){

            cuenta = i*i - array.get(i-1);
            array.add(cuenta);
            i++;
        }

        System.out.println("Tamaño: " + array.size());

        System.out.println(array);
    }
}
