package com.css.app.xlgl.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {
    public static void main(String[] args) {

        TestController testController = new TestController();
        testController.getCore(27, 23);


    }

    /**
     * 男子单杠引体向上 俯卧撑
     *
     * @param age
     * @param score
     */
    public void getCore(int age, int score) {
        int s = 0;
        int c = 0;
        if (age <= 24) {
            if ((score >= 10 && score <= 12)) {
                int t = 12 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 65 - s;
            } else if (score > 12 && score <= 14) {
                int t = 14 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 75 - s;
            } else if (score == 15) {
                c = 75;
            } else if (score > 15 && score <= 30) {
                int t = 30 - score;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 100 - s;
            } else if (score > 30) {
                c = score - 30 + 100;
            }
        } else if (age >= 25 && age <= 27) {
            if (score >= 9 && score <= 11) {
                int t = 11 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 65 - s;
            } else if (score > 11 && score <= 13) {
                int t = 13 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 70 - s;
            } else if (score > 14 && score <= 16) {
                int t = 16 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 80 - s;
            } else if (score > 16 && score <= 28) {
                int t = 28 - score;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 100 - s;
            } else if (score > 28) {
                c = score - 28 + 100;
            }
        } else if (age >= 28 && age <= 30) {
            if (score >= 8 && score <= 12) {
                int t = 12 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 75 - s;
            } else if (score > 12 && score <= 14) {
                int t = 14 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 80 - s;
            } else if (score > 14 && score <= 26) {
                int t = 26 - score;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 100 - s;
            } else if (score > 26) {
                c = score - 26 + 100;
            }
        } else if (age >= 31 && age <= 33) {
            if (score >= 7 && score <= 11) {
                int t = 11 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 75 - s;
            } else if (score > 11 && score <= 17) {
                int t = 17 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 90 - s;
            } else if (score > 17 && score <= 23) {
                int t = 23 - score;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 100 - s;
            } else if (score > 23) {

                c = score - 23 + 100;
            }
        } else if (age >= 34 && age <= 36) {
            if (score >= 6 && score <= 12) {
                int t = 12 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 85 - s;
            } else if (score > 12 && score <= 14) {
                int t = 14 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 90 - s;
            } else if (score > 14 && score <= 20) {
                int t = 20 - score;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 100 - s;
            } else if (score > 20) {
                c = score - 20 + 100;
            }
        } else if (age >= 37 && age <= 39) {
            if (score >= 5 && score <= 11) {
                int t = 11 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 85 - s;
            } else if (score > 11 && score <= 17) {
                int t = 17 - score;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 100 - s;
            } else if (score > 17) {
                c = score - 17 + 100;
            }
        } else if (age >= 40 && age <= 42) {
            if (score >= 27 && score <= 29) {
                int t = 29 - score;
                int d = t * 5 % 1;
                if (d == 0) {
                    s = t * 5 / 1;
                } else {
                    s = t * 5 / 1 + 1;
                }
                c = 65 - s;
            } else if (score > 29 && score <= 39) {
                int t = 39 - score;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 75 - s;
            } else if (score > 39 && score <= 57) {
                int t = 57 - score;
                int d = (57 - score) * 5 % 6;
                if (d == 0) {
                    s = (57 - score) * 5 / 6;
                } else {
                    s = (57 - score) * 5 / 6 + 1;
                }
                c = 90 - s;
            } else if (score > 57 && score <= 73) {
                int t = 73 - score;
                int d = t * 5 % 8;
                if (d == 0) {
                    s = t * 5 / 8;
                } else {
                    s = t * 5 / 8 + 1;
                }
                c = 90 - s;
            } else if (age >= 43 && age <= 45) {
                if (score >= 26 && score <= 28) {
                    int t = 28 - score;
                    int d = (28 - score) * 5 % 1;
                    if (d == 0) {
                        s = (28 - score) * 5 / 1;
                    } else {
                        s = (28 - score) * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 28 && score <= 31) {
                    int t = 31 - score;
                    int d = t * 5 % 3;
                    if (d == 0) {
                        s = t * 5 / 3;
                    } else {
                        s = t * 5 / 3 + 1;
                    }
                    c = 70 - s;
                } else if (score > 32 && score <= 55) {
                    int t = 55 - score;
                    int d = t * 5 % 6;
                    if (d == 0) {
                        s = t * 5 / 6;
                    } else {
                        s = t * 5 / 6 + 1;
                    }
                    c = 90 - s;
                } else if (score > 56 && score <= 69) {
                    int t = 69 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                }
            } else if (age >= 46 && age <= 48) {
                if (score >= 23 && score <= 25) {
                    int t = 25 - score;
                    int d = t * 5 % 1;
                    if (d == 0) {
                        s = t * 5 / 1;
                    } else {
                        s = t * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 25 && score <= 30) {
                    int t = 30 - score;
                    int d = t * 5 % 5;
                    if (d == 0) {
                        s = t * 5 / 5;
                    } else {
                        s = t * 5 / 5 + 1;
                    }
                    c = 70 - s;
                } else if (score > 31 && score <= 54) {
                    int t = 54 - score;
                    int d = t * 5 % 6;
                    if (d == 0) {
                        s = t * 5 / 6;
                    } else {
                        s = t * 5 / 6 + 1;
                    }
                    c = 90 - s;
                } else if (score > 55 && score <= 68) {
                    int t = 68 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                }
            } else if (age >= 49 && age <= 51) {
                if (score >= 21 && score <= 23) {
                    int t = 23 - score;
                    int d = t * 5 % 1;
                    if (d == 0) {
                        s = t * 5 / 1;
                    } else {
                        s = t * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 23 && score <= 28) {
                    int t = 28 - score;
                    int d = t * 5 % 5;
                    if (d == 0) {
                        s = t * 5 / 5;
                    } else {
                        s = t * 5 / 5 + 1;
                    }
                    c = 70 - s;
                } else if (score > 29 && score <= 52) {
                    int t = 52 - score;
                    int d = t * 5 % 6;
                    if (d == 0) {
                        s = t * 5 / 6;
                    } else {
                        s = t * 5 / 6 + 1;
                    }
                    c = 90 - s;
                } else if (score > 53 && score <= 66) {
                    int t = 66 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                }
            } else if (age >= 52 && age <= 54) {
                if (score >= 18 && score <= 20) {
                    int t = 20 - score;
                    int d = t * 5 % 1;
                    if (d == 0) {
                        s = t * 5 / 1;
                    } else {
                        s = t * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 20 && score <= 44) {
                    int t = 44 - score;
                    int d = t * 5 % 6;
                    if (d == 0) {
                        s = t * 5 / 6;
                    } else {
                        s = t * 5 / 6 + 1;
                    }
                    c = 85 - s;
                } else if (score > 44 && score <= 65) {
                    int t = 65 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                } else if (score > 44 && score <= 65) {
                    int t = 65 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                }
            } else if (age >= 55 && age <= 57) {
                if (score >= 16 && score <= 18) {
                    int t = 18 - score;
                    int d = t * 5 % 1;
                    if (d == 0) {
                        s = t * 5 / 1;
                    } else {
                        s = t * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 18 && score <= 48) {
                    int t = 48 - score;
                    int d = t * 5 % 6;
                    if (d == 0) {
                        s = t * 5 / 6;
                    } else {
                        s = t * 5 / 6 + 1;
                    }
                    c = 90 - s;
                } else if (score > 49 && score <= 62) {
                    int t = 62 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                } else if (score > 49 && score <= 62) {
                    int t = 62 - score;
                    int d = t * 5 % 7;
                    if (d == 0) {
                        s = t * 5 / 7;
                    } else {
                        s = t * 5 / 7 + 1;
                    }
                    c = 100 - s;
                }
            } else if (age >= 58 && age <= 60) {
                if (score >= 10 && score <= 12) {
                    int t = 12 - score;
                    int d = t * 5 % 1;
                    if (d == 0) {
                        s = t * 5 / 1;
                    } else {
                        s = t * 5 / 1 + 1;
                    }
                    c = 65 - s;
                } else if (score > 12 && score <= 15) {
                    int t = 15 - score;
                    int d = t * 5 % 3;
                    if (d == 0) {
                        s = t * 5 / 3;
                    } else {
                        s = t * 5 / 3 + 1;
                    }
                    c = 70 - s;
                } else if (score > 15 && score <= 25) {
                    int t = 25 - score;
                    int d = t * 5 % 5;
                    if (d == 0) {
                        s = t * 5 / 5;
                    } else {
                        s = t * 5 / 5 + 1;
                    }
                    c = 80 - s;
                } else if (score > 25 && score <= 29) {
                    int t = 29 - score;
                    int d = t * 5 % 4;
                    if (d == 0) {
                        s = t * 5 / 4;
                    } else {
                        s = t * 5 / 4 + 1;
                    }
                    c = 85 - s;
                } else if (score > 29 && score <= 44) {
                    int t = 44 - score;
                    int d = t * 5 % 5;
                    if (d == 0) {
                        s = t * 5 / 5;
                    } else {
                        s = t * 5 / 5 + 1;
                    }
                    c = 100 - s;
                }
            }
            System.out.println(c);
        }

    }

    /**
     * 男子仰卧起坐
     */
    @ResponseBody
    @RequestMapping("/getywqz")
    public void getywqz(int age, int num) {
        int s = 0;
        int c = 0;
        if (age <= 24) {
            if (num >= 46 && num <= 62) {
                int t = 62 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 75 - s;
            } else if (num >= 62 && num <= 87) {
                int t = 87 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 87) {
                c = 100 + (num - 100) / 2;
            }

        } else if (age >= 25 && age <= 27) {
            if (num >= 43 && num <= 67) {
                int t = 67 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 67 && num <= 82) {
                int t = 82 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 82) {
                c = 100 + (num - 100) / 2;
            }
        } else if (age >= 28 && age <= 30) {
            if (num >= 41 && num <= 65) {
                int t = 65 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 65 && num <= 80) {
                int t = 80 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 80) {
                c = 100 + (num - 100) / 2;
            }
        } else if (age >= 31 && age <= 33) {
            if (num >= 39 && num <= 63) {
                int t = 63 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 65 && num <= 80) {
                int t = 80 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 80) {
                c = 100 + (num - 80) / 2;
            }
        } else if (age >= 34 && age <= 36) {
            if (num >= 35 && num <= 55) {
                int t = 55 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 80 - s;
            } else if (num > 55 && num <= 75) {
                int t = 75 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 75) {
                c = 100 + (num - 75) / 2;
            }
        } else if (age >= 37 && age <= 39) {
            if (num >= 30 && num <= 45) {
                int t = 45 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 70 - s;
            } else if (num > 45 && num <= 49) {
                int t = 49 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 75 - s;
            } else if (num > 49 && num <= 74) {
                int t = 74 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 100 - s;
            } else if (num > 74) {
                c = (num - 74) / 2 + 100;
            }
        } else if (age >= 40 && age <= 42) {
            if (num >= 28 && num <= 38) {
                int t = 38 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 65 - s;
            } else if (num > 38 && num <= 41) {
                int t = 41 - num;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 70 - s;
            } else if (num > 41 && num <= 71) {
                int t = 71 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 71) {
                c = (num - 71) / 2 + 100;
            }
        } else if (age >= 43 && age <= 45) {
            if (num >= 25 && num <= 35) {
                int t = 35 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 65 - s;
            } else if (num > 35 && num <= 39) {
                int t = 39 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 70 - s;
            } else if (num > 39 && num <= 69) {
                int t = 69 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 69) {
                c = (num - 69) / 2 + 100;
            }
        } else if (age >= 46 && age <= 48) {
            if (num >= 23 && num <= 33) {
                int t = 33 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 65 - s;
            } else if (num > 33 && num <= 37) {
                int t = 37 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 70 - s;
            } else if (num > 37 && num <= 47) {
                int t = 47 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 80 - s;
            } else if (num > 47 && num <= 51) {
                int t = 51 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 51 && num <= 66) {
                int t = 66 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 66) {
                c = (num - 69) / 2 + 100;
            }
        } else if (age >= 49 && age <= 51) {
            if (num >= 21 && num <= 26) {
                int t = 26 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 60 - s;
            } else if (num > 26 && num <= 32) {
                int t = 32 - num;
                int d = t * 5 % 6;
                if (d == 0) {
                    s = t * 5 / 6;
                } else {
                    s = t * 5 / 6 + 1;
                }
                c = 65 - s;
            } else if (num > 32 && num <= 35) {
                int t = 35 - num;
                int d = t * 5 % 3;
                if (d == 0) {
                    s = t * 5 / 3;
                } else {
                    s = t * 5 / 3 + 1;
                }
                c = 70 - s;
            } else if (num > 35 && num <= 39) {
                int t = 39 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 75 - s;
            } else if (num > 39 && num <= 44) {
                int t = 44 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 80 - s;
            } else if (num > 44 && num <= 48) {
                int t = 48 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 48 && num <= 63) {
                int t = 63 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 63) {
                c = (num - 63) / 2 + 100;
            }
        } else if (age >= 52 && age <= 54) {
            if (num >= 19 && num <= 29) {
                int t = 29 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 65 - s;
            } else if (num > 29 && num <= 37) {
                int t = 37 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 75 - s;
            } else if (num > 37 && num <= 42) {
                int t = 42 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 80 - s;
            } else if (num > 42 && num <= 46) {
                int t = 46 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 85 - s;
            } else if (num > 46 && num <= 61) {
                int t = 61 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 61) {
                c = (num - 61) / 2 + 100;
            }
        } else if (age >= 55 && age <= 57) {
            if (num >= 17 && num <= 22) {
                int t = 22 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 60 - s;
            } else if (num > 22 && num <= 26) {
                int t = 26 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 65 - s;
            } else if (num > 26 && num <= 31) {
                int t = 31 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 70 - s;
            } else if (num > 31 && num <= 39) {
                int t = 39 - num;
                int d = t * 5 % 4;
                if (d == 0) {
                    s = t * 5 / 4;
                } else {
                    s = t * 5 / 4 + 1;
                }
                c = 80 - s;
            } else if (num > 39 && num <= 59) {
                int t = 59 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 59) {
                c = (num - 59) / 2 + 100;
            }
        } else if (age >= 58 && age <= 60) {
            if (num >= 15 && num <= 17) {
                int t = 17 - num;
                int d = t * 5 % 2;
                if (d == 0) {
                    s = t * 5 / 2;
                } else {
                    s = t * 5 / 2 + 1;
                }
                c = 60 - s;
            } else if (num > 17 && num <= 57) {
                int t = 57 - num;
                int d = t * 5 % 5;
                if (d == 0) {
                    s = t * 5 / 5;
                } else {
                    s = t * 5 / 5 + 1;
                }
                c = 100 - s;
            } else if (num > 57) {
                c = (num - 57) / 2 + 100;
            }
        }
        System.out.println(c);
    }
}
