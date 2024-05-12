package com.stacksandqueues.monotonic;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumNumberOfRobotsWithinBudget {
    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> queue=new LinkedList<>();
        int left=0;
        long sumRunningCosts=0;
        for(int right=0;right< chargeTimes.length;right++){
            sumRunningCosts+=runningCosts[right];
            while(!queue.isEmpty() && chargeTimes[queue.peekLast()]<=chargeTimes[right]){
                queue.pollLast();
            }
            queue.addLast(right);
            if(chargeTimes[queue.getFirst()]+(right-left+1)*sumRunningCosts>budget){
                if(queue.getFirst()==left){
                   queue.pollFirst();
                }
                sumRunningCosts-=runningCosts[left];
                left++;
            }
        }
        return chargeTimes.length-left;

        /*----------------My Solution--------------------------------------------------------------------
        Deque<Integer> queue=new LinkedList<>();
        long sumRunningCosts=0, totalCost, ans=0;
        int maxChargeTimes=0, left=0;
        for(int right=0;right< chargeTimes.length;right++){
            maxChargeTimes=Math.max(maxChargeTimes,chargeTimes[right]);
            sumRunningCosts+=runningCosts[right];
            queue.addLast(right);
            totalCost=maxChargeTimes+(queue.size())*sumRunningCosts;
            while(!queue.isEmpty() && totalCost>budget){
                queue.removeFirst();
                sumRunningCosts-=runningCosts[left];
                left++;
                maxChargeTimes=0;
                if(!queue.isEmpty()){
                    for(int j=queue.getFirst();j<=queue.getLast();j++){
                        maxChargeTimes=Math.max(maxChargeTimes,chargeTimes[j]);
                    }
                }
                totalCost=maxChargeTimes+(queue.size())*sumRunningCosts;
            }
            ans=Math.max(ans,queue.size());
        }
        return (int)ans;
        ------------------------------------------------------------------------------------------------*/
    }
    public static void main(String[] args){
        int[] chargeTimes = {3,6,1,3,4};
        int[] runningCosts = {2,1,3,4,5};
        int budget = 25;
        /*int[] chargeTimes = {11,12,19};
        int[] runningCosts = {10,8,7};
        int budget = 19;*/
        /*int[] chargeTimes = {8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11};
        int[] runningCosts = {1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37};
        int budget = 412;*/
        /*int[] chargeTimes = {19,63,21,8,5,46,56,45,54,30,92,63,31,71,87,94,67,8,19,89,79,25};
        int[] runningCosts = {91,92,39,89,62,81,33,99,28,99,86,19,5,6,19,94,65,86,17,10,8,42};
        int budget = 85;*/
        /*int[] chargeTimes = {6564,57,5103,81,825,7893,5641,844,7372,4055,6320,1027,6823,4739,2620,9073,336,6265,5272,2120,3239,2877,4778,383,7097,8962,1595,7673,8389,3228,6333,1206,4945,3434,488,4441,1532,6443,6448,9740,9898,6747,8032,2137,8833,7128,1462,5029,3891,9675,2475,5698,8545,6890,6634,1299,8020,5510,5887,8115,8569,3401,1221,4724,6830,6334,4538,4577,4885,149,4483,6472,5986,7622,5983,1929,112,8847,8706,506,4043,7139,3835,4252,1691,9573,8762,7162,8404,9767,3705,2246,7694,9606,1642,3203,9818,7701,5787,3388,4978,9384,130,1383,2376,8113,9640,3676,3943,4655,4058,9426,6793,2432,3964,1576,4599,3555,9068,2272,6677,9634,9907,9750,7472,6859,2601,1041,9041,9054,9689,4703,650,6679,7304,8255,8046,3375,6752,3790,8336,7757,1252,963,8778,9701,9666,7001,4003,9339,610,106,6616,4940,6172,6843,5571,1302,9356,8380,874,4055,6548,5708,1552,4118,7076,1113,8571,8795,4435,4911,9922,7633,2181,9762,2037,5143,6658,4803,1403,2218,7007,6688,2114,3323,9968,3931,1144,4950,7163,3574,2444,1266,7754,1813,2642,5403,1100,5952,5297,8105,2097,3866,2030,4802,2197,6743,7819,7096,1607,1893,9696,2993,1653,587,4756,3311,8746,1280,8078,6107,2397,9050,6962,2040,8323,3423,6685,8627,6030,321,9783,727,4412,5597,8393,5913,9185,3207,711,9781,9989,7080,2710,3289,8134,7569,6643,4145,274,6207,9854,4918,5972,2065,3630,8373,606,3943,6841,1311,2079,5778,5314,5347,443,2449,2376,3214,2314,9827,6337,8597,9055,3101,1579,2552,6585,2452,6828,5883,4681,6982,6053,1875,2209,4592,5883,8962,2987,1046,3188,4796,1319,5607,5136,9805,4359,8787,684,6801,3643,3794,9424,638,7161,1434,7702,9632,4082,595,5088,1473,624,4299,8924,8276,8269,5497,932,2249,6030,3128,5181,4876,1852,5480,5678,3184,248,9456,4798,4249,9984,234,2058,9403,2216,1588,8357,8437,873,332,9317,4,4936,75,4721,8730,6683,6280,5638,3299,4783,1995,3499,8098,8957,7,3172,3706,9220,2926,9807,9663,5158,9217,1052,9966,845,840,3373,6574,111,8688,4170,4061,520,4108,8765,3070,5910,920,4274,7319,8698,1995,7299,1172,7828,3790,1457,4222,8283,2775,131,69,1859,4078,2197,1179,8954,2520,8139,5037,3033,7465,6779,646,2257,2206,9670,9194,7076,8131,1656,3209,9939,8570,3486,6655,1812,1531,9834,3057,3725,3158,2036,4694,7943,8912,7751,6179,8910,6437,462,7686,6888,7418,5188,50,9173,1068,6902,4716,6967,5101,3273,8400,5877,9439,8092,6574,689,3389,3983,4975,6601,71,9975,6992,7409,7304,4666,882,6878,887,6885,6799,640,2414,5652,2864,3255,6750,2244,2366,8008,1173,2986,181,9178,7533,5247,3623,7707,4810,845,1851,6634,6232,7754,5450,665,7225,5154,7419,6647,167,5457,6479,4765,2986,6605,2089,717,8827,4764,7307,393,690,2663,5903,2013,5222,1118,5300,25,9220,139,4475,4149,7122,641,239,1021,391,8853,5693,3219,4131,4373,8649,797,4239,8146,5645,6265,8094,3829,9833,611,9668,1683,9582,6471,9314,9226,9539,8130,9925,7256,8669,6270,9598,3374,2929,8790,522,4683,7321,2912,3060,5212,4585,6792,3910,5660,2978,8828,8725,6179,870,4540,9835,6993,3822,4796,9907,31,7376,8740,6464,8829,6962,4027,4146,6632,5154,163,3999,1380,6080,465,8314,9652,8507,9485,5868,558,6638,5301,9939,122,5800,823,9893,566,9184,3431,9296,2230,3252,7588,9513,7876,5612,5491,3026,6627,1231,8489,4897,4297,6829,1093,697,2997,5311,6732,2315,1299,6919,8496,2978,2297,2943,7224,5465,1345,9340,9145,7288,1446,8960,1025,8217,4189,8854,8570,1984,6802,7585,5502,6667,9564,7125,2771,9491,5498,1575,8254,2272,2438,4882,152,5079,8631,979,3215,9932,9639,487,3606,9826,2112,1185,1677,3488,1620,9741,7939,6268,9381,6953,6115,2865,2871,4600,647,1511,5554,2262,1003,2648,509,3807,7339,4078,9388,9997,6856,6164,9890,9393,436,3172,6814,1163,2023,8974,9565,4750,4337,4310,9460,2766,195,9944,4754,5222,9427,141,242,552,782,825,824,643,5016,3225,2089,3710,5461,3364,1166,4075,7255,2655,7883,9502,7334,3524,3158,4300,6019,2762,3615,9092,7779,7837,8685,3992,8309,3880,3280,2337,4998,6770,4974,1481,6909,1034,274,1173,4907,4719,462,5294,9552,3614,6502,3712,4815,921,9357,6797,9558,4027,2984,1849,6317,3441,229,5807,6290,6600,2396,8439,2117,705,8055,189,5815,4889,9728,4493,2185,9483,724,7341,9896,7698,2500,9666,6234,929,1896,1254,5922,9622,1190,2839,651,1854,4991,1808,8351,2259,3693,4946,4613,1536,9950,9703,6750,7778,675,7107,1445,692,9021,3597,4666,7161,8604,560,380,6213,9461,6311,456,9087,2564,1629,445,7403,193,501,1923,7720,4211,1411,9189,9772,7169,9684,9365,4353,6787,2813,7015,5023,2343,4564,3168,285,1114,2642,8814,8421,7656,5874,5540,865,6811,4079,9342,8546,9142,7387,5012,1177,9644,3608,634,3683,6995,2043,3685,801,9568,7426,9369,8707,9628,7808,2339,3721,522,3066,9742,3972,9482,4263,7716,6578,6027,656,8135,2831,2622,7875,9738,8364,372,6314,106,4602,8621,2266,9371,9393,486,4027,7410,7160,9939,8255,3702,8217,1379,141,1509,852,8122,7375,493,7994,1104,2937,3972,1120,4639,5546,7861,8998,6078,8840,9183,7824,9519,7481,1533,5715,7792,9894,1909,3178,9598,6170,6027,3545,5902,6499,7182,9729,9783,4131,1340,4377,5999,9996,7708,3210,6194,2792,1418,3729,186,2523,9449,9322,9012,3436,2721,2962,5862,7137,2149,4067,5759,3750,9720,5791,8227,4434,6651,3868,6773,4012,6115,9850,2073,5321,9792,6092,7821,611,6973,4895,1752,8548,9008,6848,2340,446,122,226,259,1463,8574,1123,4143,2813,4168,6304,2151,5925,5672,1846,4941,544,605,7694,9323,5653,3819,3376,6229,2587,9792,4960,5173,8550,9074,2447,2067,6426,9336,6069,7151,6600,5539,9399,223,6149,3835,3591,7853,6731,9024,3598,6671,9676,2764,4825,4554,5707,1847,6711,508,6790,6135,3420,1414,2107,151,3913,8748,3603,158,4088,6741,5629,1515,1056,2029,714,1783,2341,4982,3296,9424,5631,1907,1923,779,7540,7812,1121,5530,1181,4752,9017,8511,3813,7038,8961,900,9199,5178,8402,3920,6089,9399,7470,8474,5592,5658,6563,6086,1544,9662,8415,8503,195,6303,6673,5570,1794,7020,7931,1705,1424,6744,5200,3108,8173,6804,1936,8062,1423,335,2286,9393,3276,5832,3964,3105,5191,8707,1133,1228,2282,6541,9527,4207,6392,7571,294,5844,9196,276,9714,6904,9062,4672,4213,2217,1996,2811,171,1008,2371,4078,7401,1471,1893,4279,6802,8660,1786,937,6403,2251,1863,149,3410,771,8417,2743,6196,1214,4587,4180,5746,2507,8012,6763,5882,7100,1031,6681,3060,5297,8710,7900,6063,362,8173,9461,2806,8292,3941,6999,823,7597,9058,5285,6623,5834,9597,2318,1423,1979,855,9352,7004,5351,9281,4489,3413,4584,6974,217,8790,8435,1838,4822,6581,7639,2443,6379,2933,9706,7185,110,9447,8808,652,785,6555,753,2723,9622,1296,8349,7656,6199,2629,5041,5136,9531,2099,6839,9712,9747,6054,3024,3862,6366,6212,5809,48,2648,8552,9457,4281,9128,7242,6763,7979,4702,9103,5458,7399,9860,2514,4630,9603,3267,1462,4279,3222,594,1250,9478,2143,1747,454,9199,5692,6641,9168,154,6316,4693,7181,4488,2651,1367,5158,970,817,1206,4958,2344,2109,180,8502,7111,2670,5612,4624,6480,9149,5527,9786,9286,977,2649,3729,7059,6514,1732,18,2321,8220,5582,9055,2320,6749,6406,1968,6161,1884,8600,4089,4524,1478,8571,3369,5347,8657,2732,9587,859,3972,5800,8615,6599,5474,7253,6141,181,6734,6788,4824,9745,3846,97,5511,9495,4813,7287,1032,5449,2438,9100,6961,9403,7627,4094,9490,4684,1764,3121,8709,1978,2423,6284,5970,1949,5585,9262,921,1006,5273,2971,5705,877,330,1823,1999,5343,9621,3523,8274,1826,5123,2368,4586,5750,5729,5075,6481,800,8143,982,3480,9085,8758,4326,4428,6429,4476,6859,5546,9002,6002,258,4115,5484,2064,4935,102,3041,4141,8975,6773,5374,2061,3386,8579,2119,2618,6180,6483,1830,9961,1793,3646,3764,8655,9956,4827,720,9524,3145,6538,2435,7059,2485,1567,4556,1363,224,3108,6402,1729,7470,8082,3146,806,7283,8764,980,1623,3333,6028,9443,5426};
        int[] runningCosts = {8616,8331,8922,5639,9840,8708,2926,2465,4127,3288,1793,7303,9072,7018,6366,5498,8787,3005,8876,305,3213,3342,7366,1426,4553,401,5437,9999,544,9856,9264,2256,9448,4605,399,1958,5163,3535,1889,7699,6682,2681,6133,2250,1057,7963,9785,3924,3261,893,6384,7379,4335,5439,4428,8965,4497,3447,4922,9300,6067,2712,7909,2140,840,2676,2335,5378,1587,6059,4915,1188,744,6507,74,785,4089,4181,9285,9895,1212,4126,250,5706,325,4031,6592,5845,1318,3735,882,1009,4226,1884,6995,9793,3958,9567,1719,3646,399,265,5039,8298,4580,2927,5742,8159,1729,8239,3745,8945,321,1320,9282,685,8590,2917,1486,5897,7424,1775,1494,5943,4252,9302,4364,3767,5050,8698,6000,5017,3771,3033,139,8857,8965,6642,7403,5242,4995,7304,9529,2127,3119,5392,8168,9009,6409,4347,5491,1981,8175,9141,8254,8950,2471,8023,476,9430,655,7982,1154,197,4202,818,3181,9682,6569,1469,5960,883,5900,6681,8265,8114,5748,4590,391,4436,183,2886,7896,1277,7661,3989,4880,9938,8265,9826,5131,1281,559,9734,1407,2388,5195,7801,721,5258,2114,1488,3942,8964,1958,1890,6155,2235,5893,5826,679,8424,757,9763,1342,7238,1954,9071,4205,2831,5654,9539,1770,686,9424,4130,1283,1491,1309,7304,7231,9282,7980,1647,183,2035,7952,2194,4437,1780,9807,517,404,9832,3052,2525,5442,1057,5148,1154,2195,2531,8258,2170,8824,2286,1485,4412,1483,8494,184,6358,3433,923,661,8025,8263,2302,92,5831,2787,7477,9955,8099,8536,3609,8101,9057,7034,344,8988,5739,3442,8155,23,1573,8230,3088,161,8119,137,9690,5372,3024,6122,723,844,1752,5714,7253,6306,2880,3553,5719,762,6498,9122,656,3752,3620,9616,4215,7037,2482,6128,5656,1337,2179,2076,3854,5353,6207,2743,142,2135,2430,4494,9322,9731,3909,5388,8075,643,7463,668,8533,5278,3075,4151,1903,6087,3778,9115,2895,125,5940,1673,748,2661,3130,8011,6952,1166,1106,1309,6791,1460,3188,7242,2323,4900,675,3488,8426,6311,1006,5483,4481,632,6468,3635,8939,2380,1845,7161,8369,9848,9726,4180,2206,2635,9126,9942,609,4837,5808,9733,1401,6893,4658,8942,9775,9662,6020,589,4041,7872,5110,1365,175,9116,7082,1748,3994,8200,842,3870,2784,871,9804,495,5335,1933,3198,9088,8356,7815,5616,9057,206,9899,2813,3580,1684,5052,1715,2253,8005,6180,8344,6723,2950,9678,4410,3556,2277,8290,7882,5344,7599,3383,2391,5668,7444,352,4829,9392,4177,5997,1817,122,6663,6898,1559,8117,1910,9546,6400,875,2601,2501,7454,3042,217,4774,4290,3392,2267,898,2329,669,2620,8847,8491,4141,8187,5788,125,8789,6974,7892,2241,7575,9872,1649,3077,9588,8872,2464,1764,3394,8338,333,3278,4415,2902,1360,4979,4445,7365,1335,7687,5572,5258,4396,8742,2583,3638,1100,656,7288,7662,2737,8842,4609,8773,5609,7309,6558,494,9078,9175,8510,1253,80,1841,7114,9868,7664,6499,4669,5623,7884,1085,5780,1031,3423,8742,6794,9501,1116,7079,1966,8920,8375,134,8063,2050,7855,9983,6044,4086,2156,918,1949,5037,4804,190,4150,6078,4245,8110,7206,1764,3766,2153,9694,7512,6066,2033,9198,8047,666,967,4695,8047,2248,4227,187,6781,4298,1730,5403,3283,9262,4540,9674,4725,9039,4430,3396,7693,7891,8714,4098,8545,1873,5464,8655,7821,8451,3545,7631,9880,5374,456,2699,7187,6842,8677,1849,3235,6340,2584,9734,9825,4761,6327,549,650,5739,5197,4379,6085,7689,69,5856,7118,9211,425,798,3088,2983,3529,4331,2236,6985,1067,4688,1775,868,1201,8901,2422,7225,7035,916,1451,7588,7733,5842,4773,4131,3788,6244,5982,7119,9725,3709,4592,5594,5029,9105,4974,3536,8870,1122,6945,8315,3958,9251,3491,9410,1845,5381,2421,1483,9371,467,5625,9197,123,2483,7967,1070,6233,7289,7406,7013,9522,7004,925,9569,274,3667,9330,3167,2238,7730,4792,4847,2079,9430,7116,8440,8663,4790,2567,6235,6553,7244,546,3910,8113,6839,3131,4324,7790,2810,1219,5789,9786,6200,7102,4749,2004,5141,2560,9194,5715,5485,3762,3447,345,8715,8077,3311,2091,8886,851,5021,1210,3056,2074,2285,1319,8099,8213,637,3134,1405,183,4571,2518,8964,762,3243,7721,8590,3638,229,592,5643,8894,1920,3301,2550,2208,3401,492,3450,7338,1667,2967,2472,3988,6811,239,3636,8539,8109,3581,4486,3147,1037,7377,5027,4716,4857,1611,9261,3761,3300,9060,5989,8982,1672,4315,1289,6659,9598,2735,1021,3991,8622,66,6092,8923,5241,2048,1647,4246,7523,2651,3406,2954,1197,9073,8059,1519,8946,9234,740,5507,6388,7886,6844,1334,8673,2578,8987,4777,4640,7193,9421,6489,5364,8936,9063,3820,6744,6415,357,3873,9205,8208,1768,1703,747,3126,5731,6796,9747,9204,5341,3598,4,2772,8339,1428,5044,6542,4692,4902,3484,5139,8431,894,3734,3148,1658,6122,7927,8533,7415,90,6863,3514,6633,5316,2050,4152,4419,3865,3345,385,1975,6853,4136,676,4927,9753,6954,5008,115,8790,6833,3763,8964,7638,8296,8459,1781,597,1265,2176,3243,6334,4492,9370,1812,1963,1940,2134,6198,7306,5993,5774,4491,540,3935,8474,7218,9915,955,6944,3500,3872,7837,3566,994,979,5,6194,5394,6765,5637,808,3098,6194,5622,9450,5688,5025,4927,9412,1316,3575,7689,2082,3260,6184,9421,3150,3689,5165,1018,9105,7241,26,2794,7914,8947,7398,9088,1293,988,8117,4046,2376,9048,3760,5,9565,5306,6415,1324,5853,7349,9149,1722,3675,7848,3640,9091,1677,5790,625,9403,7909,3135,5154,2209,798,1506,839,4664,140,3607,9655,9986,9419,6775,5711,7137,3986,7859,6628,7394,6474,756,1681,674,5837,9490,8897,8020,5363,4898,5390,1840,9619,6324,3462,5525,5226,3686,8676,3786,4059,6285,516,131,3020,4948,5735,6428,321,8094,2072,3250,4840,9082,6304,3306,5905,4343,55,5230,2513,5782,7269,2788,8882,7968,6897,2365,7911,1883,489,4799,5416,532,2506,3539,2018,9909,4553,3082,8379,5320,236,9316,5992,6071,4349,4678,7773,4454,8947,5564,8278,488,7409,3614,3221,7753,6641,4251,2542,6047,6117,4684,90,7906,763,4590,5995,9411,8711,8307,6818,226,2349,2021,1732,5473,33,9334,6391,2469,9965,6856,2769,6291,7252,3438,2034,8102,4721,2012,5283,5889,3719,4380,677,365,2345,4651,973,4810,7116,856,1456,3960,8272,8305,4005,1484,3042,8327,9740,8506,4753,5618,5456,4999,1700,8583,7500,292,624,1,5531,5429,7589,4422,1429,9816,4289,5188,5293,6267,7615,2124,2552,1349,1827,7262,825,7404,8997,8444,5935,6305,2653,5764,5713,994,4756,3504,9664,6955,8149,9738,2681,5688,8354,5729,5070,3525,2282,6027,1124,2096,3228,9697,6529,9421,1588,2301,7345,604,2463,8522,6928,3230,8493,3207,7286,873,5918,5588,5571,9029,835,7753,9172,8270,5134,9570,6853,707,3165,1291,7933,3557,8169,2661,6607,5999,8222,9584,2139,6402,1525,600,2566,5791,4853,763,1159,8328,4222,5306,8979,1466,2709,5930,2693,178,414,8100,5011,820,4155,6548,9044,4910,1930,936,7276,272,3254,5504,666,1725,1292,2101,2901,4014,1339,6028,7206,4621,1379,6323,6345,1254,8357,373,7226,6617,1198,731,2397,3079,1579,667,5435,5530,5447,1777,6404,3375,2755,1527,6932,891,2353,2525,4294,3238,3700,8955,7611,170,1544,6306,3273,5293,7373,1819,9579,545,4869,1707,2165,628,4766,3680,6180,9446,6134,3113,4226,7120,7669,6307,953,4373,1832,4768,1908,2525,9209,2532,4677,8137,414,2621,5014,6295,4939,7687,1170,5787,8150,4395,7677,9223,396,2795,3727,7657,1753,1120,1458,4508,2685,256,2957,4645,926,367,4158,2097,8917,6603,4624,6226,140,6299,8957,4007,5429,284,2090,4274,309,1904,3765,7241,9716,5932,8751,8418,9958,2052,9252,6799,6577,4673,2908,8699,1472,1862,5210,6361,361,3616,7992,190,3580,4686,8010,2293,938,9673,6630,3457,7603,3487,6846,9437,9990,3957,4260,1029,4179,9562,7489,114,1107,1571,8169,3425,9526,9080,3775,7422,9599,641,2251,7988,2931,5363,112,3879,9317,1310,6810,7688,2015,3596,1662,695,183,9452,9962,102,1743,4668,3100,8906,1946,6995,6669,5723,8290,6119,1562,5712,8778,8845,9491,8418,8637,4146,6461,2833,9009,9330,4502,3066,7172,5144,4959,9788,9950,512,352,3852,7324};
        long budget = 6564015800L;*/
        /*int[] chargeTimes = {4,4,1};
        int[] runningCosts = {3,1,2};
        int budget = 7;*/
        System.out.println("The maximum number of robots within the budget is: "+maximumRobots(chargeTimes,runningCosts,budget));
    }

}
