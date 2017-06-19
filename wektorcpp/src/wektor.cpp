#include "wektor.hpp"
#include <iostream>

using std::cout;
using std::endl;

Wektor::Wektor(){
    x = 0;
    y = 0;
    z = 0;
}

Wektor::Wektor(int x2){
   x = x2;
   y = 0;
   z = 0;
}

Wektor::Wektor(int x2,int y2){
    x = x2;
    y = y2;
    z = 0;
}

Wektor::Wektor(int x2,int y2,int z2){
    x = x2;
    y = y2;
    z = z2;
}

Wektor Wektor::add(Wektor V){
    if(V.x == 0 && V.y == 0 && V.z == 0) {throw "You want to add useless Wektor?!";}
    Wektor Vadd(x+V.x,y+V.y,z+V.z);
    return Vadd;
}

 Wektor Wektor::sub(Wektor V){
    if(V.x == 0 && V.y == 0 && V.z == 0) {throw "You want to substract useless Wektor?!";}
    Wektor Vadd(x-V.x,y-V.y,z-V.z);
    return Vadd;

 }

 Wektor Wektor::mul(Wektor V){
    Wektor Vadd(x*V.x,y*V.y,z*V.z);
    return Vadd;
 }

bool Wektor::equals(Wektor V){
    if(x == V.x && y == V.y && z == V.z){return true;}
    return false;
}

void Wektor::reverse(){
    x = -x;
    y = -y;
    z = -z;
}