#include <wektor.hpp>
#include <catch.hpp>

//Obvious TEST_CASE
TEST_CASE("Simple tests") {
    Wektor V1(1,2);
    Wektor V2(3,4,5);
    bool result = false;
    SECTION("Adding V1 and V2") {
        Wektor V3(4,6,5);
        result = V3.equals(V1.add(V2));
        REQUIRE(result == true);
    }
    SECTION("Reverse V1") {
        V1.reverse();
        REQUIRE(V1.x == -1);
        REQUIRE(V1.y == -2);
    }
}

//Scenario with all operations
SCENARIO("Operations tests") {
    bool result;
    Wektor V0(0);                           //To throw checks
    Wektor V1(1);
    Wektor V2(2,3);
    Wektor Vadd(3,3);                       //To check add test
    Wektor V4(4,5,6);
    Wektor Vsub(2,2,6);                     //To check substract test
    Wektor V5(10,15,20);
    Wektor Vmul(40,75,120);                 //To check multiple test
    //Wektor V4(V1.add(V2));
    GIVEN("Created Wektors to add") {
        REQUIRE(&V0 != NULL);               //Check used Wektors
        REQUIRE(&V1 != NULL);           
        REQUIRE(&V2 != NULL);
        REQUIRE(&Vadd != NULL);
        WHEN("Added Wektors V1 and V2") {
            REQUIRE_THROWS(Vadd.equals(V1.add(V0)));
            THEN("The result should be true"){
                REQUIRE_NOTHROW(Vadd.equals(V1.add(V2)));
                REQUIRE(Vadd.equals(V1.add(V2)));
            }
        }
    }
    GIVEN("Created Wektors to substract") {
        REQUIRE(&V4 != NULL);
        REQUIRE(&Vsub != NULL);
        WHEN("Substract Wektors V4 and V2") {
            REQUIRE_THROWS(Vsub.equals(V4.sub(V0)));
            THEN("The result should be true"){
                REQUIRE(Vsub.equals(V4.sub(V2)));
            }
        }
    }
    GIVEN("Created Wektors") {
        REQUIRE(&V5 != NULL);
        REQUIRE(&Vmul != NULL);
        WHEN("Multiple Wektors V4 and V5") {
            REQUIRE_NOTHROW(Vmul.equals(V4.mul(V5)));
            THEN("The result should be true"){
                REQUIRE(Vmul.equals(V4.mul(V5)));
            }
        }
    }
}
