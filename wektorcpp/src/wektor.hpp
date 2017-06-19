#ifndef __WEKTOR_HPP__
#define __WEKTOR_HPP__

class Wektor{
    public:
    int x;
    int y;
    int z;
    Wektor();
    Wektor(int x2);
    Wektor(int x2,int y2);
    Wektor(int x2,int y2,int z2);
    Wektor add(Wektor V);
    bool equals(Wektor V);
    Wektor sub(Wektor V);
    Wektor mul(Wektor V);
    void reverse();
};

#endif // __WEKTOR_HPP__
