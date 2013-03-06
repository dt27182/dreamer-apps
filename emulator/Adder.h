#ifndef __Adder__
#define __Adder__

#include "emulator.h"

class Adder_t : public mod_t {
 public:
  dat_t<8> Adder__io_out;
  dat_t<8> io_in0;
  dat_t<8> io_in1;

  void init ( bool rand_init = false );
  void clock_lo ( dat_t<1> reset );
  void clock_hi ( dat_t<1> reset );
  void print ( FILE* f );
  bool scan ( FILE* f );
  void dump ( FILE* f, int t );
};

#endif
